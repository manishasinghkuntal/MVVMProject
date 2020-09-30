package com.example.mvvmtutorial.helper

import com.example.mvvmtutorial.`interface`.APiInterface
import com.example.mvvmtutorial.di.DaggerApiComponent
import com.example.mvvmtutorial.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class CommonService {
@Inject
    lateinit var  api:APiInterface

    init{
DaggerApiComponent.create().inject(this)
    }

    fun getCountries(): Single<List<Country>> {
return api.getData()
    }
}