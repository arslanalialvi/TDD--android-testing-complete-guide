package com.example.tdd1.mock

import com.example.tdd1.model.QUOTE_STATUS
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations

class QuoteUseCaseTest {
    @Mock
    lateinit var   quoteRepository: QuoteRepository
    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
        Mockito.`when`(quoteRepository.verifyQuote(anyString(), anyString())).thenReturn(QUOTE_STATUS.INVALID_QUOTE)
    }
    @Test
    fun testQuoteUseCase(){
        val sut= QuoteUseCase(quoteRepository)
        val status=sut.verifyQuote("hard","2")
        Assert.assertEquals("Quote not exist.",status)

    }

    @After
    fun tearDown(){

    }
}