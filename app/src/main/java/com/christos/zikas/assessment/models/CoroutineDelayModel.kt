package com.christos.zikas.assessment.models

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

interface CoroutineDelayModel {
    fun runAsync(delay: Int, runnable: Runnable)
}

class CoroutineDelayModelImpl: CoroutineDelayModel {
    override fun runAsync(delay: Int, runnable: Runnable) {
        GlobalScope.async {
            kotlinx.coroutines.delay(4000)
            runnable.run()
        }
    }

}