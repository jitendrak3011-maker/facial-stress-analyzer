package com.example.facialstressanalyzer.data.repository

import com.example.facialstressanalyzer.data.model.StressData
import com.example.facialstressanalyzer.data.source.RemoteDataSource
import com.example.facialstressanalyzer.data.source.LocalDataSource

class StressRepository(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource) {

    // Function to fetch stress data from remote
    suspend fun fetchStressData(): List<StressData> {
        return remoteDataSource.getStressData().also { localDataSource.saveStressData(it) }
    }

    // Function to get stress data from local storage
    suspend fun getLocalStressData(): List<StressData> {
        return localDataSource.getStressData()
    }
}