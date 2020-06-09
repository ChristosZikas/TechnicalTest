package com.christos.zikas.assessment

import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import org.greenrobot.eventbus.EventBus
import org.mockito.Mockito

class EventBusUnitTestHandler : EventBusHandler {

    private val bus: EventBus = Mockito.spy(EventBus.getDefault())

    override fun <T> removeSticky(eventType: Class<T>) {
        bus.removeStickyEvent(eventType)
    }

    override fun <T> postSticky(eventType: T) = bus.postSticky(eventType)
    override fun <T> post(eventType: T) = bus.post(eventType)

    fun <T> verifyPost(eventType: T) = Mockito.verify(bus).post(eventType)
    fun <T> verifyPostSticky(eventType: T) = Mockito.verify(bus).postSticky(eventType)
    fun <T> verifyRemoveSticky(eventType: T) = Mockito.verify(bus).removeStickyEvent(eventType)


}