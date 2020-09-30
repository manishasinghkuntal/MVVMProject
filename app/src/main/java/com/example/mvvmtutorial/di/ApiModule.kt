package com.example.mvvmtutorial.di

import com.example.mvvmtutorial.`interface`.APiInterface
import com.example.mvvmtutorial.helper.CommonService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule{
    private   val baseUrl:String="https://raw.githubusercontent.com"
    @Provides
    fun ProvideCountriesApi(): APiInterface{
return Retrofit.Builder()
    .baseUrl(baseUrl)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    .build()
    .create(APiInterface::class.java)
    }
}