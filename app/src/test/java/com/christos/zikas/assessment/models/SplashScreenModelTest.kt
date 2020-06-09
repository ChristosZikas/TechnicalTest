package com.christos.zikas.assessment.models

import com.christos.zikas.assessment.CoroutineDelayModelTest
import com.christos.zikas.assessment.EventBusUnitTestHandler
import org.junit.Before
import org.junit.Test

class SplashScreenModelTest {

    lateinit var splashScreenModel: SplashScreenModel
    private val bus = EventBusUnitTestHandler()
    private val coroutineTest = CoroutineDelayModelTest()

    @Before
    fun setUp() {
        splashScreenModel = SplashScreenModelImpl(bus, coroutineTest)
    }

    @Test
    fun `WHEN passing on a runnable THEN a SplashScreenCompletedEvent is fired`() {
        splashScreenModel.startCount()
        bus.verifyPostSticky(SplashScreenCompletedEvent)
    }

}