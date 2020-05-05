package com.concrete.concretenosofa.repository

import com.concrete.concretenosofa.models.BaseModel
import com.concrete.concretenosofa.models.WeatherRequestResponse
import retrofit2.Response

interface Services {

    suspend fun getWeatherInfo(): BaseModel<WeatherRequestResponse>

}