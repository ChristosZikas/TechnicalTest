package com.christos.zikas.assessment.utils.retrofit

import com.christos.zikas.assessment.models.BeerModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface BeerApi {

    @GET("beers")
    fun getBeer(
        @Query("page") page: Int,
        @Query("per_page") perPage: Int = 10
    ): Single<List<BeerModel>>


}