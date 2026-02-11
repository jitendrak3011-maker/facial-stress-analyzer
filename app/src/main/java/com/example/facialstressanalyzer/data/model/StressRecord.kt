package com.example.facialstressanalyzer.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stress_records")
data class StressRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val stressLevel: Int,
    val dateTime: String,
    val notes: String? = null
)