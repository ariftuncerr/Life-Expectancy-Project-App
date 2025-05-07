package com.example.lifeexpectancy.service

import com.example.lifeexpectancy.model.LifeExpectancyModel
import com.example.lifeexpectancy.model.PredictResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/predict")
    suspend fun predictLifeExpectancy(
        @Body data: LifeExpectancyModel
    ): Response<PredictResponse>
}