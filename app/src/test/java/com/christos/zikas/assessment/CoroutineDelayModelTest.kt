package com.christos.zikas.assessment

import com.christos.zikas.assessment.models.CoroutineDelayModel

class CoroutineDelayModelTest : CoroutineDelayModel {
    override fun runAsync(delay: Int, runnable: Runnable) = runnable.run()
}