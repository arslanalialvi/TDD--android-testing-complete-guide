package com.example.tdd1.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.example.tdd1.data.local.QuoteDao
import com.example.tdd1.data.local.QuoteDatabase
import com.example.tdd1.data.local.QuoteEntity
import com.example.tdd1.util.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class QuotesDaoTest {
    @get:Rule
    val instantExecutorRule= InstantTaskExecutorRule()
    lateinit var quoteDatabase: QuoteDatabase
    lateinit var quoteDao: QuoteDao

    @Before
    fun setUp(){
        quoteDatabase= Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(), QuoteDatabase::class.java).allowMainThreadQueries().build()
        quoteDao=quoteDatabase.quoteDao()
    }
    @Test
    fun insertQuote_expectedSingleQuote()= runBlocking() {

        val quote= QuoteEntity(0,"Test quote","Arslan")
        quoteDao.insertQuote(quote)
        val result= quoteDao.getQuote().getOrAwaitValue()
        assertEquals(1,result.size)
        assertEquals("Test quote",result[0].text)
    }
    @Test
    fun deleteQuote_expectedSingleQuote()= runBlocking {
        val quote= QuoteEntity(0,"Test quote","Arslan")
        quoteDao.insertQuote(quote)
        quoteDao.deleteQuotes()
        val result= quoteDao.getQuote().getOrAwaitValue()
        assertEquals(0,result.size)
    }
    @After
    fun tearDown(){
        quoteDatabase.close()
    }
}