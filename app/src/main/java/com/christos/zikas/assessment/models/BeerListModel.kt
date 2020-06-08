package com.christos.zikas.assessment.models

import androidx.lifecycle.MutableLiveData
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

interface BeerListModel {
    fun getList(): MutableLiveData<List<BeerModel>>
    fun getList(page: Int, delay: Long = 300)
    fun setLoader()

    val beerList: MutableLiveData<List<BeerModel>>
    val setLoader: MutableLiveData<Unit>
}

class BeerListModelImpl @Inject constructor(private val api: BeerApiWrapper): BeerListModel {

    override val beerList: MutableLiveData<List<BeerModel>> = MutableLiveData()
    override val setLoader: MutableLiveData<Unit> = MutableLiveData()
    override fun getList(): MutableLiveData<List<BeerModel>> = beerList
    override fun setLoader() = setLoader.postValue(Unit)

    override fun getList(page: Int, delay: Long) {
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
                    getList(page, 1000)
                }
            })
    }
}