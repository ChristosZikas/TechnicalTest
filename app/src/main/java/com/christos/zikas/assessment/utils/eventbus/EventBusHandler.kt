package com.christos.zikas.assessment.utils.eventbus

import org.greenrobot.eventbus.EventBus

interface EventBusHandler {
    fun <T> removeSticky(eventType: Class<T>)
    fun <T> postSticky(eventType: T)
    fun <T> post(eventType: T)
}

class EventBusHandlerImpl : EventBusHandler {

    override fun <T> removeSticky(eventType: Class<T>) {
        EventBus.getDefault().removeStickyEvent(eventType)
    }

    override fun <T> postSticky(eventType: T) {
        EventBus.getDefault().postSticky(eventType)
    }

    override fun <T> post(eventType: T) {
        EventBus.getDefault().post(eventType)
    }

}
