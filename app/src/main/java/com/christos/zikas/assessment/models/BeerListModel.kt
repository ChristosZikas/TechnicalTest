package com.christos.zikas.assessment.models

import androidx.lifecycle.MutableLiveData
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class BeerListModelImpl @Inject constructor(
    private val api: BeerApiWrapper
) {

    private val beerList: MutableLiveData<List<BeerModel>> = MutableLiveData()

    fun getList(): MutableLiveData<List<BeerModel>> = beerList

    fun getList(page: Int, delay: Long = 0) {
        api.beerApi
            .getBeer(page)
            .subscribeOn(Schedulers.io())
            .delay(delay, TimeUnit.MILLISECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : SingleObserver<List<BeerModel>> {
                override fun onSuccess(responseList: List<BeerModel>) {
                    beerList.value = responseList
                }

                override fun onSubscribe(d: Disposable) {}
                override fun onError(e: Throwable) {
                    getList(page, 300)
                }
            })
    }
}