package com.christos.zikas.assessment.models

interface ItemApiHandler {
    fun onSuccess(responseList: List<BeerModel>)
    fun onError(e: Throwable)
    val page: Int
}