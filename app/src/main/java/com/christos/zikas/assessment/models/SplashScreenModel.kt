package com.christos.zikas.assessment.models

import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import javax.inject.Inject

interface SplashScreenModel

object SplashScreenCompletedEvent

class SplashScreenModelImpl
@Inject constructor(
    private val bus: EventBusHandler,
    private val coroutineDelayModel: CoroutineDelayModel
) : SplashScreenModel,
    EventBusHandler by bus {
    fun startCount() = coroutineDelayModel.runAsync(4000, Runnable { postSticky(SplashScreenCompletedEvent) })

}