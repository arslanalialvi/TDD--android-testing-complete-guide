package com.example.tdd1.utils

import kotlinx.coroutines.*

class Helper {
    fun isPalindrome(input:String): Boolean{
        var i=0;
        var j= input.length-1
        var result=true
        while (i<j){
            if (input[i]!=input[j]){
                result=false
                break
            }
            i++
            j--
        }
        return result

    }
    fun isOddNumber( number: Int?): Int?{

        var str: String?= null
        return str!!.length!!
    }
    fun verifyPassword(input: String): String{
        when{
            input.isEmpty()->{
                return "Empty String"
            }
            input.length<6->{
                return "Password must be greater than 6"
            }
            input.length>15->{
                return "Password must be less than 15"
            }
            else->{
                return "valid"
            }
        }
    }
    fun reverseString(reverseString: String?): String{
        if (reverseString==null){
            throw IllegalArgumentException()
        }
        var chars= reverseString.toCharArray()
        var i=0
        var j= chars.size-1
        while (i<j){
            val temp= chars[i]
            chars[i]=chars[j]
            chars[j]=temp
            i++
            j--

        }
        return chars.joinToString("")

    }



}