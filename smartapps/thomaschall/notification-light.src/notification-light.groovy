/**
 *  Notification Light
 *
 *  Copyright 2015 Thomas Hall
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 */
 
definition(
    name: "Notification Light",
    namespace: "thomaschall", 
    author: "Thomas Hall",
    description: "Turn on a notification light based on different triggers.",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Meta/light_outlet@2x.png"
)


preferences {


	section(hideable: false, hidden: false, "Notification"){
		input(name: "NotificationSwitch", type: "capability.switch", title: "Notification Light", required: false, multiple: true)
	}


        section(hideable: true, hidden: true, "Trigger 1"){
            input(name: "TriggerName_1", type:"text", title: "Trigger Name", description:"Trigger $item", required: false, multiple: false)
			input(name: "TriggerPriority_1", type:"enum", title: "Trigger Priority", options: ["100":"Emergency", "200":"Super Important", "300":"Important", "400":"Somewhat Important", "500":"Really Need to Know", "600":"Kind of Need to Know", "700":"FYI"], multiple:false, required: false)
            input(name: "TriggerColor_1", type: "enum", title: "Notification Color", options: ["White","Red", "Orange","Yellow", "Green", "Blue", "Violet"], multiple:false, required: false)
            input(name: "TriggerAndOr_1", type: "enum", title: "Notify When", options: ["Any of the following are active","All of the following are active"], multiple: false, required: false)
            input(name: "SwitchOn_1", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_1", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_1", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_1", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}



}


def installed() {
	log.debug "Installed with settings: ${settings}"
	initialize()
}

def updated() {
	log.debug "Updated with settings: ${settings}"

	unsubscribe()
	initialize()
}

def initialize() {
    subscribeToEvents()
}


def subscribeToEvents() {

    def list2 = [1]
 //   for(item in list2){

        subscribe(settings."SwitchOn_1", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_1", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_1", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_1", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_1", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_1", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_1", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_1", "water.wet", eventHandler)
    
//    }
}


def eventHandler(evt) {
    setNotification(evt)
}


private setNotification(evt) {

    log.debug "Notification: $evt"


	def NotificationActive = false
    def NotificationActiveTrigger = null
    def TriggerList = [1]
    def PriorityList = ["100", "200", "300", "400", "500", "600", "700", null] // Needs to be in order of most important to least important

    for(PriorityItem in PriorityList){

        for(TriggerItem in TriggerList){
        
			if (PriorityItem == settings."TriggerPriority_$TriggerItem") {

//       		log.info "Current Priority: " + settings."TriggerPriority_$TriggerItem"
//        		log.info "Current And/Or: " + settings."TriggerAndOr_$TriggerItem"

				// Only turn something on if it is equal or greater to the current priority.
//				if (settings."TriggerPriority_$TriggerItem" >= state.CurrentPriority) {
					
                    // Is the trigger active
					// Trigger on based on the and/or parameter
                    if (settings."TriggerAndOr_$TriggerItem" == "All of the following are active") {
                    
                    	//TODO: Add the logic for all of the following are active.
						NotificationActive = SetNotificationOr(TriggerItem)
						NotificationActiveTrigger = $TriggerItem
                    } else {  // Or is the default and used if null
						NotificationActive = SetNotificationOr(TriggerItem)
						NotificationActiveTrigger = $TriggerItem
                    }
//				}
			}
        	if (NotificationActive) { break }
		}
    	if (NotificationActive) { break }
	}
    
    // Set the notification light
    if (NotificationActive) {
        NotificationSwitch?.on()
//        state.CurrentPriority = settings."TriggerPriority_$NotificationActiveTrigger"
	} else {
        NotificationSwitch?.off()
//        state.CurrentPriority = null
    }
    
}


private SetNotificationOr(TriggerItem){

    // Check SwitchOn to see if it is on
    if (settings."SwitchOn_$TriggerItem" != null && settings."SwitchOn_$TriggerItem".currentValue("switch").contains("on")) {
        log.info "Notification: Switch on"
        return true


        // Check to see if a door is unlocked
    } else if (settings."DoorIsUnlocked_$TriggerItem" != null && settings."DoorIsUnlocked_$TriggerItem".currentValue("lock").contains("unlocked")) {
        log.info "Notification: Door unlocked"
        return true

        // Check to see if a contact sensor is open
    } else if (settings."ContactIsOpen_$TriggerItem" != null && settings."ContactIsOpen_$TriggerItem".currentValue("contact").contains("open")) {
        log.info "Notification: Contact sensor open"
        return true

        // Check to see if a an area is wet
    } else if (settings."WaterDetected_$TriggerItem" != null && settings."WaterDetected_$TriggerItem".currentValue("water").contains("wet")) {
        log.info "Notification: Water detected"
        return true

    } else {
    	return false
        

    }

}


private SetNotificationAnd(TriggerItem){
	return true
}
