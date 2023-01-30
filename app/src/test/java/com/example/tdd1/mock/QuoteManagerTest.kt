package com.example.tdd1.mock

import android.content.Context
import android.content.res.AssetManager
import com.example.tdd1.manager.QuoteManager
import com.nhaarman.mockitokotlin2.doReturn
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.util.Objects

class QuoteManagerTest {
    @Mock
    lateinit var context: Context
    @Mock
    lateinit var assetManager: AssetManager
    @Before
    fun setUp(){
        MockitoAnnotations.openMocks(this)
    }
    @Test
    fun `mock quote manager json`(){
        val testStream= QuoteUseCaseTest::class.java.getResourceAsStream("/quots.json")
        doReturn(assetManager).`when`(context).assets
        Mockito.`when`(context.assets.open(anyString())).thenReturn(testStream )
        val sut= QuoteManager()
        sut.populateQuotefromAssets(context,"")
        val quote= sut.getCurrentQuote()
        Assert.assertEquals("Life isn’t about getting and having, it’s about giving and being.",quote.quote)
    }
    @After
    fun tearDown(){

    }
}