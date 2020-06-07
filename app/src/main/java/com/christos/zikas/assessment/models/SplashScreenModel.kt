package com.christos.zikas.assessment.models

import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import com.christos.zikas.assessment.utils.eventbus.EventBusHandlerImpl
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import javax.inject.Inject

interface SplashScreenModel

object SplashScreenCompletedEvent

class SplashScreenModelImpl
@Inject constructor(bus: EventBusHandler) : SplashScreenModel,
    EventBusHandler by bus {
//    constructor() : this(EventBusHandlerImpl())

    init {
        GlobalScope.async {
            delay(4000)
            bus.post(SplashScreenCompletedEvent)
        }
    }
}