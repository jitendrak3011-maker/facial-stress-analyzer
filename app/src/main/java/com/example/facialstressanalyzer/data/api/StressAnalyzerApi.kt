package com.example.facialstressanalyzer.data.api

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface StressAnalyzerApi {
    @POST("analyze")
    fun analyzeStress(@Body request: StressRequest): Call<StressResponse>
}

data class StressRequest(val data: String)

data class StressResponse(val result: String)