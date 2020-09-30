package com.example.mvvmtutorial.model

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("name")
    val countryName: String?,
    @SerializedName("Capital")
    val capital: String?,
    @SerializedName("flagPNG")
    val flag: String?)