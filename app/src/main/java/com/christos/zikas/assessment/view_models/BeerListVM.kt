package com.christos.zikas.assessment.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.BeerListModelImpl
import com.christos.zikas.assessment.models.BeerModel
import javax.inject.Inject

abstract class BeerListVM : ViewModel() {
    abstract fun itemsRetrieved(): LiveData<List<BeerModel>>
    abstract fun retrieveNextPage(nextPage: Int)
    abstract fun setLoader(): LiveData<Unit>
    abstract fun error(): LiveData<Unit>
}

class BeerListVMImpl
@Inject constructor(private val beerListModel: BeerListModelImpl) : BeerListVM() {
    override fun setLoader(): LiveData<Unit> = beerListModel.setLoader
    override fun error(): LiveData<Unit> = beerListModel.onError
    override fun itemsRetrieved(): LiveData<List<BeerModel>> = beerListModel.getList()
    override fun retrieveNextPage(nextPage: Int) {
        beerListModel.setLoader()
        beerListModel.retrieveList(nextPage)
    }

}