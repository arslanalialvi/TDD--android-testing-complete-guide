package com.example.tdd1.coroutines

import com.example.tdd1.utils.CoroutineUtils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CoroutineUtilTest {

    lateinit var util: CoroutineUtils
    @get:Rule
    val mainCoroutineRule= MainCoroutineRule()

    //Replace these setUp and tearDown dispatcher definition with with get Rule(MainCoroutineRule)
//    private val testDispatcher= StandardTestDispatcher()
    @Before
    fun setUp(){
        util= CoroutineUtils(mainCoroutineRule.dispatcher)
      //  Dispatchers.setMain(testDispatcher)
    }
    @Test
    fun `test corutine without dispatcher`(){
        //runBlocking is a solution but includes delay, so use runTest to avoid delays
        runTest {
            util.getName()
        }
    }
    @Test
    fun `test corutine with main dispatcher`(){
        //runBlocking is a solution but includes delay, so use runTest to avoid delays
        runTest {
            util.getUserByMainDispatcher()
        }
    }
    @Test
    fun `test corutine with IO dispatcher`(){
        //runBlocking is a solution but includes delay, so use runTest to avoid delays
        runTest {
            util.getUserByIODispatcher()
        }
    }

  /*  @After
    fun tearDown(){

        Dispatchers.resetMain()
    }*/
}