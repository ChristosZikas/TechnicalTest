package com.christos.zikas.assessment.models

import androidx.lifecycle.MutableLiveData
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import javax.inject.Inject

interface BeerListModel {
    fun getList(): MutableLiveData<List<BeerModel>>
    fun retrieveList(page: Int)
    fun setLoader()
    fun onError()
    val onError: MutableLiveData<Unit>
    val beerList: MutableLiveData<List<BeerModel>>
    val setLoader: MutableLiveData<Unit>
}

class BeerListModelImpl @Inject constructor(private val api: BeerApiWrapper) :
    BeerListModel {

    var handler: ItemApiHandler = object : ItemApiHandler {
        override fun onSuccess(responseList: List<BeerModel>) = beerList.postValue(responseList)
        override fun onError(e: Throwable) = onError()
    }

    override val beerList: MutableLiveData<List<BeerModel>> = MutableLiveData()
    override val setLoader: MutableLiveData<Unit> = MutableLiveData()
    override val onError: MutableLiveData<Unit> = MutableLiveData()
    override fun getList(): MutableLiveData<List<BeerModel>> = beerList
    override fun setLoader() = setLoader.postValue(Unit)
    override fun onError() = onError.postValue(Unit)

    override fun retrieveList(page: Int) {
        api.retrieveBeerList(page, handler)
    }
}