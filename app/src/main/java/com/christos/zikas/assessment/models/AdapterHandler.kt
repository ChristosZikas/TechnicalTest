package com.christos.zikas.assessment.models

interface AdapterHandler {
    fun load(nextPage: Int)
    fun selectBeer(selectedItem: BeerModel)
}