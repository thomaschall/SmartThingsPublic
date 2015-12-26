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
    description: "Turn on a notification light based on different prioritized triggers.",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/smartlights.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/smartlights@2x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/smartlights@3x.png"
)


preferences {


	section(hideable: false, hidden: false, "Notification"){
		input(name: "NotificationSwitch", type: "capability.switch", title: "Notification Light", required: false, multiple: true)

}


        section(hideable: true, hidden: true, "Trigger 1"){
            input(name: "TriggerName_1", type:"text", title: "Trigger Name", description:"Trigger 1", required: false, multiple: false)
			input(name: "TriggerPriority_1", type:"enum", title: "Trigger Priority", defaultValue: "500", options: ["100":"Emergency", "300":"Super Important", "500":"Important", "700":"Need to Know", "900":"FYI"], multiple:false, required: true)
            input(name: "SwitchOn_1", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_1", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_1", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_1", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}
        
        section(hideable: true, hidden: true, "Trigger 2"){
            input(name: "TriggerName_2", type:"text", title: "Trigger Name", description:"Trigger 2", required: false, multiple: false)
			input(name: "TriggerPriority_2", type:"enum", title: "Trigger Priority", defaultValue: "500", options: ["100":"Emergency", "300":"Super Important", "500":"Important", "700":"Need to Know", "900":"FYI"], multiple:false, required: true)
            input(name: "SwitchOn_2", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_2", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_2", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_2", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}
        
        section(hideable: true, hidden: true, "Trigger 3"){
            input(name: "TriggerName_3", type:"text", title: "Trigger Name", description:"Trigger 3", required: false, multiple: false)
			input(name: "TriggerPriority_3", type:"enum", title: "Trigger Priority", defaultValue: "500", options: ["100":"Emergency", "300":"Super Important", "500":"Important", "700":"Need to Know", "900":"FYI"], multiple:false, required: true)
            input(name: "SwitchOn_3", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_3", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_3", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_3", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}
        
        section(hideable: true, hidden: true, "Trigger 4"){
            input(name: "TriggerName_4", type:"text", title: "Trigger Name", description:"Trigger 4", required: false, multiple: false)
			input(name: "TriggerPriority_4", type:"enum", title: "Trigger Priority", defaultValue: "500", options: ["100":"Emergency", "300":"Super Important", "500":"Important", "700":"Need to Know", "900":"FYI"], multiple:false, required: true)
            input(name: "SwitchOn_4", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_4", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_4", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_4", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}

        section(hideable: true, hidden: true, "Trigger 5"){
            input(name: "TriggerName_5", type:"text", title: "Trigger Name", description:"Trigger 5", required: false, multiple: false)
			input(name: "TriggerPriority_5", type:"enum", title: "Trigger Priority", defaultValue: "500", options: ["100":"Emergency", "300":"Super Important", "500":"Important", "700":"Need to Know", "900":"FYI"], multiple:false, required: true)
            input(name: "SwitchOn_5", type: "capability.switch", title: "When Switch Turns On", required: false, multiple: true)
            input(name: "DoorIsUnlocked_5", type: "capability.lock", title: "When Door Unlocks", required: false, multiple: true)
            input(name: "ContactIsOpen_5", type: "capability.contactSensor", title: "When Contact Opens", required: false, multiple: true)
            input(name: "WaterDetected_5", type: "capability.waterSensor", title: "When Water Detected", required: false, multiple: true)
//			TODO: Add time to start and stop
		}

        section(hideable: true, hidden: true, "Priority Colors"){
			paragraph "If your notification light has the ability to change colors, this will assign the varoius colors to the different priorities."
			input(name: "Emergency_Color", type:"enum", title: "Emergency", defaultValue: "Red", options: ["White","Red","Orange","Yellow","Green","Blue","Purple"], multiple:false, required: true)
			input(name: "Superimportant_Color", type:"enum", title: "Super Important", defaultValue: "Orange", options: ["White","Red","Orange","Yellow","Green","Blue","Purple"], multiple:false, required: true)
			input(name: "Important_Color", type:"enum", title: "Important", defaultValue: "Yellow", options: ["White","Red","Orange","Yellow","Green","Blue","Purple"], multiple:false, required: true)
			input(name: "Needtoknow_Color", type:"enum", title: "Need to Know", defaultValue: "Blue", options: ["White","Red","Orange","Yellow","Green","Blue","Purple"], multiple:false, required: true)
			input(name: "Fyi_Color", type:"enum", title: "FYI", defaultValue: "White", options: ["White","Red","Orange","Yellow","Green","Blue","Purple"], multiple:false, required: true)
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


        subscribe(settings."SwitchOn_1", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_1", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_1", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_1", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_1", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_1", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_1", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_1", "water.wet", eventHandler)

        subscribe(settings."SwitchOn_2", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_2", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_2", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_2", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_2", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_2", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_2", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_2", "water.wet", eventHandler)
        
        subscribe(settings."SwitchOn_3", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_3", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_3", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_3", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_3", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_3", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_3", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_3", "water.wet", eventHandler)

        subscribe(settings."SwitchOn_4", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_4", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_4", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_4", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_4", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_4", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_4", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_4", "water.wet", eventHandler)
        
        subscribe(settings."SwitchOn_5", "switch.on", eventHandler)
        subscribe(settings."SwitchOn_5", "switch.off", eventHandler)
        subscribe(settings."DoorIsUnlocked_5", "lock.locked", eventHandler)
        subscribe(settings."DoorIsUnlocked_5", "lock.unlocked", eventHandler)
        subscribe(settings."ContactIsOpen_5", "contact.open", eventHandler)
        subscribe(settings."ContactIsOpen_5", "contact.closed", eventHandler)
        subscribe(settings."WaterDetected_5", "water.dry", eventHandler)
        subscribe(settings."WaterDetected_5", "water.wet", eventHandler)
}


def eventHandler(evt) {
    setNotification(evt)
}


private setNotification(evt) {

    log.debug "Notification: $evt"


	def NotificationActive = false
    def NotificationActiveTrigger = null
    def TriggerList = [1,2,3,4,5]
    def PriorityList = ["100", "300", "500", "700", "900", null] // Needs to be in order of most important to least important

    for(PriorityItem in PriorityList){

        for(TriggerItem in TriggerList){
        
			if (PriorityItem == settings."TriggerPriority_$TriggerItem") {

                log.info "Current Priority: " + settings."TriggerPriority_$TriggerItem"
				// Is the trigger active
				NotificationActive = SetNotification(TriggerItem)
				NotificationActiveTrigger = TriggerItem
			}
        	if (NotificationActive) { break }
		}
    	if (NotificationActive) { break }
	}
    
    // Set the notification light
    if (NotificationActive) {
        def colorMap = null
		def ActiveColor = null

		// Get the color of the notification light
		if (settings."TriggerPriority_$NotificationActiveTrigger" == "100") {
        	ActiveColor = settings."Emergency_Color"
        } else if (settings."TriggerPriority_$NotificationActiveTrigger" == "300") {
        	ActiveColor = settings."Superimportant_Color"
        } else if (settings."TriggerPriority_$NotificationActiveTrigger" == "500") {
        	ActiveColor = settings."Important_Color"
        } else if (settings."TriggerPriority_$NotificationActiveTrigger" == "700") {
        	ActiveColor = settings."Needtoknow_Color"
        } else if (settings."TriggerPriority_$NotificationActiveTrigger" == "900") {
        	ActiveColor = settings."Fyi_Color"
        }
        
		log.info "NotificationActiveTrigger: " + NotificationActiveTrigger
		log.info "Active Color: " + ActiveColor

        if (ActiveColor == "Red"){
			colorMap = [hue:100,saturation:100,level:100,alpha:1]
        } else if (ActiveColor == "Orange"){
			colorMap = [hue:8,saturation:100,level:100,alpha:1]
        } else if (ActiveColor == "Yellow"){
			colorMap = [hue:14,saturation:100,level:100,alpha:1]
        } else if (ActiveColor == "Green"){
			colorMap = [hue:32,saturation:100,level:100,alpha:1]
        } else if (ActiveColor == "Blue"){
			colorMap = [hue:60,saturation:100,level:100,alpha:1]
        } else if (ActiveColor == "Purple"){
			colorMap = [hue:80,saturation:100,level:100,alpha:1]
        } else {
			ActiveColor = "White"
			colorMap = [hue:84,saturation:0,level:100,alpha:1]
        }
    
		log.info "Color Map: " + colorMap

		NotificationSwitch.on()
        if (ActiveColor == "White"){
        	NotificationSwitch.reset()
        } else {
			NotificationSwitch.setColor(colorMap)
        }
	} else {
        NotificationSwitch.off()
    }
    
}


private SetNotification(TriggerItem){

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