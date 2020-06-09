package com.christos.zikas.assessment.utils.retrofit

import android.util.Log
import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.models.ItemApiHandler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

interface BeerApiWrapper {
    fun retrieveBeerList(handler: ItemApiHandler)
}

class BeerApiWrapperImpl: BeerApiWrapper {
    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }

    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
        ).build()

    var beerApi: BeerApi

    init {
        beerApi = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BeerApi::class.java)
    }

    override fun retrieveBeerList(handler: ItemApiHandler) {
        beerApi
            .getBeer(handler.page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(300, TimeUnit.MILLISECONDS)
            .subscribe(object : SingleObserver<List<BeerModel>> {
                override fun onSuccess(responseList: List<BeerModel>) = handler.onSuccess(responseList)
                override fun onError(e: Throwable) = handler.onError(e)
                override fun onSubscribe(d: Disposable) {}
            })
    }
}