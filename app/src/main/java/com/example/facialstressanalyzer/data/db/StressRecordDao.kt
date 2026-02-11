package com.example.facialstressanalyzer.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StressRecordDao {
    @Insert
    suspend fun insert(stressRecord: StressRecord)

    @Update
    suspend fun update(stressRecord: StressRecord)

    @Query("SELECT * FROM stress_records WHERE id = :id")
    suspend fun getStressRecordById(id: Int): StressRecord?

    @Query("SELECT * FROM stress_records")
    suspend fun getAllStressRecords(): List<StressRecord>

    @Query("DELETE FROM stress_records WHERE id = :id")
    suspend fun deleteStressRecordById(id: Int)
}