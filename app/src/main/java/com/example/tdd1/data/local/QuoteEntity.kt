package com.example.tdd1.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuoteEntity(
    @PrimaryKey(autoGenerate = true)val id: Int,
    val text: String,
    val author: String
    )
