package com.example.lifeexpectancy.model

import com.google.gson.annotations.SerializedName

data class LifeExpectancyModel(
    val Year: Int,

    @SerializedName("Adult Mortality")
    val adultMortality: Int,

    @SerializedName("infant deaths")
    val infantDeaths: Int,

    val Alcohol: Double,

    @SerializedName("percentage expenditure")
    val percentageExpenditure: Double,

    @SerializedName("Hepatitis B")
    val hepatitisB: Int,

    @SerializedName("Measles ")
    val measles: Int,  // sonunda boşluk var

    @SerializedName(" BMI ")
    val bmi: Double,   // başında ve sonunda boşluk var

    @SerializedName("under-five deaths ")
    val underFiveDeaths: Int,  // sonunda boşluk var

    val Polio: Int,

    @SerializedName("Total expenditure")
    val totalExpenditure: Double,

    @SerializedName("Diphtheria ")
    val diphtheria: Int,  // sonunda boşluk var

    @SerializedName(" HIV/AIDS")
    val hivAids: Double,  // başında boşluk var

    val GDP: Double,
    val Population: Int,

    @SerializedName(" thinness  1-19 years")
    val thinness_1_19_years: Double,

    @SerializedName(" thinness 5-9 years")
    val thinness_5_9_years: Double,

    @SerializedName("Income composition of resources")
    val incomeCompositionOfResources: Double,

    val Schooling: Double,

    @SerializedName("Status_Developing")
    val statusDeveloping: Int
)

data class PredictResponse(
    val prediction: Double
)
