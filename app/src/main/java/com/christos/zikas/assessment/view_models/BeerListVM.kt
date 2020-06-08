package com.christos.zikas.assessment.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.christos.zikas.assessment.models.BeerListModelImpl
import com.christos.zikas.assessment.models.BeerModel
import javax.inject.Inject

abstract class BeerListVM : ViewModel() {
    abstract fun itemsRetrieved(): LiveData<List<BeerModel>>
    abstract fun retrieveNextPage(): Unit
}

class BeerListVMImpl @Inject constructor(private val beerListModel: BeerListModelImpl) :
    BeerListVM() {

    var currentPage = 0

    override fun itemsRetrieved(): LiveData<List<BeerModel>> = beerListModel.getList()

    init {
        retrieveNextPage()
    }

    override fun retrieveNextPage() = beerListModel.getList(++currentPage)


}