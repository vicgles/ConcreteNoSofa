package com.concrete.concretenosofa.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.concrete.concretenosofa.mockBaseModelSuccessWeatherInfo
import com.concrete.concretenosofa.mockWeatherSuccessResponse
import com.concrete.concretenosofa.models.BaseModel
import com.concrete.concretenosofa.models.WeatherRequestResponse
import com.concrete.concretenosofa.network.RetrofitConfig
import com.concrete.concretenosofa.repository.ServicesRepository
import com.concrete.concretenosofa.rules.CoroutineTestRule
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class HomeRepositoryTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutineTestRule = CoroutineTestRule()

    val api = mockk<RetrofitConfig>()
    val service = ServicesRepository(api)

    @Test
    fun givenRepositorySuccessCall_whenCallGetWeatherInfo_shouldReturnBaseModelObjectCreated() {
        coEvery { api.retrofitRequest().getWeather() } returns mockWeatherSuccessResponse()
        lateinit var actual: BaseModel<WeatherRequestResponse>
        runBlocking{
            actual = service.getWeatherInfo()
        }
        assertEquals(mockBaseModelSuccessWeatherInfo(), actual)
    }

}