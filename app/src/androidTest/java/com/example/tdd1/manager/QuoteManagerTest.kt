package com.example.tdd1.manager

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.tdd1.model.Quote
import com.google.gson.JsonSyntaxException
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.FileNotFoundException

class QuoteManagerTest {

    lateinit var context: Context
    lateinit var quoteManager: QuoteManager
    @Before
    fun setUp() {
         context= ApplicationProvider.getApplicationContext<Context>()
        quoteManager= QuoteManager()


    }

    @After
    fun tearDown() {
    }



    @Test(expected = FileNotFoundException::class)
    fun `populate_wrong_json_file`() {
            quoteManager.populateQuotefromAssets(context,"")

    }
    @Test(expected = JsonSyntaxException::class)
    fun `populate_invalid_json_file`() {
        quoteManager.populateQuotefromAssets(context,"mal.json")

    }
    @Test
    fun `populate_valid_json_file`() {
        quoteManager.populateQuotefromAssets(context,"quotes.json")
        assertEquals(102,quoteManager.quoteList.size)

    }
    @Test
    fun testPreviousQuote_expected_correct_Quote(){
        //arrange
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is the first Quote","1"),
                Quote("This is the second Quote","2"),
                Quote("This is the third Quote","3")))
        //Act

       val quote= quoteManager.getPreviousQuote()
        //Assert
        assertEquals("1",quote.author)

    }
    @Test
    fun testNextQuote_expected_correct_Quote(){
        //arrange
        quoteManager.populateQuotes(
            arrayOf(
                Quote("This is the first Quote","1"),
                Quote("This is the second Quote","2"),
                Quote("This is the third Quote","3")))
        //Act

        val quote= quoteManager.getNextQuote()
        //Assert
        assertEquals("2",quote.author)

    }


}