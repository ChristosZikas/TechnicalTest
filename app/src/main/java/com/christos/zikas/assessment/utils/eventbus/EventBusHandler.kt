package com.christos.zikas.assessment.utils.eventbus

import org.greenrobot.eventbus.EventBus

interface EventBusHandler {
    fun hasSubscriber(subscribedClass: Class<*>?): Boolean
    fun <T> removeSticky(eventType: Class<T>)
    fun <T> getSticky(eventType: Class<T>): T?
    fun <T> postSticky(eventType: T)
    fun <T> post(eventType: T)
    fun <T> hasSticky(eventType: Class<T>): Boolean
    fun busRegister(classCheck: Any)
}

class EventBusHandlerImpl : EventBusHandler {
    override fun hasSubscriber(subscribedClass: Class<*>?): Boolean {
        return EventBus.getDefault().hasSubscriberForEvent(subscribedClass)
    }

    override fun <T> removeSticky(eventType: Class<T>) {
        EventBus.getDefault().removeStickyEvent(eventType)
    }

    override fun <T> getSticky(eventType: Class<T>): T? {
        return EventBus.getDefault().getStickyEvent(eventType)
    }

    override fun <T> postSticky(eventType: T) {
        EventBus.getDefault().postSticky(eventType)
    }

    override fun <T> post(eventType: T) {
        EventBus.getDefault().post(eventType)
    }

    override fun <T> hasSticky(eventType: Class<T>): Boolean {
        return (EventBus.getDefault().getStickyEvent(eventType) != null)
    }

    override fun busRegister(classCheck: Any) {
        if (!EventBus.getDefault().isRegistered(classCheck)) EventBus.getDefault().register(classCheck)
    }

}
