package com.example.tdd1.utils

import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class HelperTest {

    lateinit var helper: Helper
    @Before
    fun setUp() {
        //Arrange
         helper= Helper()
    }

    @After
    fun tearDown() {
    }
    @Test
    fun `verify password with empty value`(){
        val result= helper.verifyPassword("")
        assertEquals("Empty String",result)
    }
    @Test
    fun `verify password with less than 6 character`(){
        val result= helper.verifyPassword("AbcD")
        assertEquals("Password must be greater than 6",result)
    }
    @Test
    fun `verify password with more than 15 character`(){
        val result= helper.verifyPassword("AbcDfdgsg4553%^&%fssgxz")
        assertEquals("Password must be less than 15",result)
    }
    @Test
    fun `verify password with valid input`(){
        val result= helper.verifyPassword("AbcDg6543")
        assertEquals("valid",result)
    }
    @Test
    fun `is Palindrome expected false`(){
        val result=helper.isPalindrome("hello")
        assertEquals(true,result)
    }
    @Test()
    fun `is Palindrome expected true`(){

        //Act
        val result= helper.isPalindrome("level")
        //assert
        assertEquals(true,result)
    }

    @Test
    fun `odd number with wrong input`() {
       val result= helper.isOddNumber(6)
        assertEquals(true,result)
    }
    @Test(expected = NullPointerException::class)
    fun `odd number with null input`() {
        val result= helper.isOddNumber(2)
    }

}