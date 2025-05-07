package com.example.lifeexpectancy.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lifeexpectancy.model.LifeExpectancyModel
import com.example.lifeexpectancy.repository.LifeExpectancyRepository
import com.google.gson.Gson
import kotlinx.coroutines.launch

class LifeExpectancyViewModel : ViewModel() {

    private val repository = LifeExpectancyRepository()

    private val _prediction = MutableLiveData<Double>()
    val prediction: LiveData<Double> = _prediction

    fun sendPredictionRequest(data: LifeExpectancyModel) {
        Log.d("POST_JSON", Gson().toJson(data))  // GÖNDERİLEN VERİ

        viewModelScope.launch {
            try {
                val response = repository.predict(data)

                if (response.isSuccessful) {
                    _prediction.value = response.body()?.prediction

                } else {
                    Log.e("API_ERROR", "Error: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("API_ERROR", "Exception: ${e.message}")
            }
        }
    }
}
