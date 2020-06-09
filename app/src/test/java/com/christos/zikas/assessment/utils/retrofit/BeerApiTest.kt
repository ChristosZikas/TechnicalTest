package com.christos.zikas.assessment.utils.retrofit

import com.christos.zikas.assessment.models.BeerModel
import io.reactivex.observers.TestObserver
import junit.framework.Assert.assertTrue
import okhttp3.OkHttpClient
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyInt
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.net.HttpURLConnection

class BeerApiTest {

    lateinit var api: BeerApi
    private val mockServer by lazy { MockWebServer() }

    @Before
    fun setup() {
        mockServer.start()

        api =
            Retrofit.Builder()
                .baseUrl(mockServer.url("/"))
                .client(OkHttpClient())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(BeerApi::class.java)
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun `ON a valid response THEN we have a success`() {
        val observer = TestObserver<List<BeerModel>>()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(BodyResponses().validBody)
        mockServer.enqueue(response)
        api.getBeer(anyInt(), anyInt()).subscribe(observer)

        observer.assertNoErrors()
        assertTrue(observer.values().isNotEmpty())
    }

    @Test
    fun `WHEN an invalid body is received THEN an error state received`() {
        val observer = TestObserver<List<BeerModel>>()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_OK)
            .setBody(BodyResponses().invalidBody)
        mockServer.enqueue(response)
        api.getBeer(anyInt(), anyInt()).subscribe(observer)

        observer.assertNoValues()
        assertTrue(observer.errors().isNotEmpty())
    }

    @Test
    fun `WHEN an invalid response code is received THEN an error state received`() {
        val observer = TestObserver<List<BeerModel>>()

        val response = MockResponse()
            .setResponseCode(HttpURLConnection.HTTP_BAD_METHOD)
            .setBody(BodyResponses().invalidBody)
        mockServer.enqueue(response)
        api.getBeer(anyInt(), anyInt()).subscribe(observer)

        observer.assertNoValues()
        assertTrue(observer.errors().isNotEmpty())
    }

}