package com.example.mvvmtutorial.`interface`

import com.example.mvvmtutorial.model.Country
import io.reactivex.Single
import retrofit2.http.GET
import javax.inject.Singleton

interface APiInterface {

    @GET("DevTides/countries/master/countriesV2.json")
    fun getData(): Single<List<Country>>;
}