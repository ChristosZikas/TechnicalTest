package com.christos.zikas.assessment.models

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapperImpl
import junit.framework.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class BeerListModelTest {

    lateinit var model: BeerListModelImpl
    lateinit var api: BeerApiWrapper

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        api = mock(BeerApiWrapperImpl::class.java)
        model = BeerListModelImpl(api)
    }

    @Test
    fun `WHEN the api return an error THEN a Unit value is fired on onError`() {
        `when`(api.retrieveBeerList(0, model.handler)).then { model.handler.onError(Throwable()) }

        model.retrieveList(0)

        assertEquals(Unit, model.onError.value)
    }

    @Test
    fun `ON an api success THEN a Unit value is fired on onError`() {
        val modelList = listOf(BeerModel())

        `when`(api.retrieveBeerList(0, model.handler)).then { model.handler.onSuccess((modelList)) }

        model.retrieveList(0)

        assertEquals(modelList, model.beerList.value)
    }

}