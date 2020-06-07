package com.christos.zikas.assessment.models

import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import javax.inject.Inject

interface SplashScreenModel

object SplashScreenCompletedEvent

class SplashScreenModelImpl
@Inject constructor(private val bus: EventBusHandler) : SplashScreenModel,
    EventBusHandler by bus {
    fun startCount() {
        GlobalScope.async {
            delay(4000)
            bus.postSticky(SplashScreenCompletedEvent)
        }
    }
}