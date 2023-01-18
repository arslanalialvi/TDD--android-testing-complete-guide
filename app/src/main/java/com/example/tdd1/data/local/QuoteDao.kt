package com.example.tdd1.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuoteDao {
    @Insert
    suspend fun insertQuote(quote: QuoteEntity)
    @Update
    suspend fun updateQuote(quote: QuoteEntity)
    @Query("Delete from QuoteEntity")
    suspend fun deleteQuotes()
    @Query("select * from QuoteEntity")
    fun getQuote(): LiveData<List<QuoteEntity>>
    @Query("select * from QuoteEntity where id = :quoteId")
    suspend fun getQuoteById(quoteId: Int): QuoteEntity
}