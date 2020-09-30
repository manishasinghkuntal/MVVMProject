package com.example.mvvmtutorial.di

import com.example.mvvmtutorial.`interface`.APiInterface
import com.example.mvvmtutorial.helper.CommonService
import dagger.Component

@Component(modules = [ApiModule::class])
interface ApiComponent{
    fun inject(service: CommonService)

}