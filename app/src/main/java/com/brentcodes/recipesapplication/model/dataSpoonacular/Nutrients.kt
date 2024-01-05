package com.brentcodes.recipesapplication.model.dataSpoonacular

import com.google.gson.annotations.SerializedName


data class Nutrients(

    @SerializedName("name") var name: String? = null,
    @SerializedName("amount") var amount: Double? = null,
    @SerializedName("unit") var unit: String? = null,
    @SerializedName("percentOfDailyNeeds") var percentOfDailyNeeds: Int? = null

)