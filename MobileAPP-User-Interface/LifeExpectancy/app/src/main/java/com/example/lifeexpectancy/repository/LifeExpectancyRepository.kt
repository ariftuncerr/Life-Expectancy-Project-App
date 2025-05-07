package com.example.lifeexpectancy.repository

import com.example.lifeexpectancy.model.LifeExpectancyModel
import com.example.lifeexpectancy.model.PredictResponse
import com.example.lifeexpectancy.service.RetrofitInstance
import retrofit2.Response


class LifeExpectancyRepository {
    suspend fun predict(data: LifeExpectancyModel): Response<PredictResponse> {
        return RetrofitInstance.api.predictLifeExpectancy(data)
    }
}
