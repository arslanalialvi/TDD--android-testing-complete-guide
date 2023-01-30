package com.example.tdd1.utils

import kotlinx.coroutines.*

class CoroutineUtils(val dispatcher: CoroutineDispatcher) {
    //Testing coroutines
    suspend fun getName(): String{
        delay(10000)
        return  "Arslan"

    }
    //As per Google recommendations, one should not hard code dispatchers but inject them,
    suspend fun getUserByMainDispatcher():String{
        /*  CoroutineScope(Dispatchers.Main).launch {
              delay(2000)
          }*/
        CoroutineScope(dispatcher).launch {
            delay(2000)
        }
        return "Arslan Ali"
    }
    suspend fun getUserByIODispatcher():String{
        withContext(dispatcher) {
            delay(2000)
        }
        return "Arslan Ali"
    }
}