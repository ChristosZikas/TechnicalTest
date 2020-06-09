package com.christos.zikas.assessment.utils.retrofit

import com.christos.zikas.assessment.models.BeerModel
import com.christos.zikas.assessment.models.ItemApiHandler
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface BeerApiWrapper {
    fun retrieveBeerList(page: Int, handler: ItemApiHandler)
}

open class BeerApiWrapperImpl @Inject constructor(private val beerApi: BeerApi) : BeerApiWrapper {
    companion object {
        const val BASE_URL = "https://api.punkapi.com/v2/"
    }

    override fun retrieveBeerList(page: Int, handler: ItemApiHandler) {
        beerApi
            .getBeer(page)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .delay(300, TimeUnit.MILLISECONDS)
            .subscribe(object : SingleObserver<List<BeerModel>> {
                override fun onSuccess(responseList: List<BeerModel>) =
                    handler.onSuccess(responseList)

                override fun onError(e: Throwable) = handler.onError(e)
                override fun onSubscribe(d: Disposable) {}
            })
    }
}