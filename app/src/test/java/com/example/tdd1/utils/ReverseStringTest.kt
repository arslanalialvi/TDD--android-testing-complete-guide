package com.example.tdd1.utils

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class ReverseStringTest {

    lateinit var helper: Helper
    @Before
    fun setUp() {
        helper= Helper()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `reverse string with empty value`() {
        val result= helper.reverseString("")
        assertEquals("",result)
    }
    @Test
    fun `reverse string with one value`() {
        val result= helper.reverseString("q")
        assertEquals("q",result)
    }
    @Test
    fun `reverse string with correct value`() {
        val result= helper.reverseString("android")
        assertEquals("diordna",result)
    }
    @Test(expected = IllegalArgumentException::class)
    fun `reverse string with null value`() {
        val result= helper.reverseString(null)
      //  assertEquals("diordna",result)
    }

}