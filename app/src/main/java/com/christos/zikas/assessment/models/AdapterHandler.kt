package com.christos.zikas.assessment.models

interface AdapterHandler {
    fun load(page: Int)
    fun selectBeer(selectedItem: BeerModel)
}