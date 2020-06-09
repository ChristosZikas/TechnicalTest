package com.christos.zikas.assessment.utils.dagger.components

import com.christos.zikas.assessment.models.CoroutineDelayModel
import com.christos.zikas.assessment.models.CoroutineDelayModelImpl
import com.christos.zikas.assessment.utils.retrofit.BeerApi
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapper
import com.christos.zikas.assessment.utils.retrofit.BeerApiWrapperImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ModelModules {
    @Provides
    fun providesBeerApiWrapper(beerApi: BeerApi): BeerApiWrapper = BeerApiWrapperImpl(beerApi)

    @Provides
    fun providesCoroutineDelayModel(): CoroutineDelayModel = CoroutineDelayModelImpl()

    @Provides
    fun providesClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
            ).build()
    }

    @Provides
    fun providesRetrofit(client: OkHttpClient): BeerApi {
        return Retrofit.Builder()
            .baseUrl(BeerApiWrapperImpl.BASE_URL)
            .client(client)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(BeerApi::class.java)
    }

}
