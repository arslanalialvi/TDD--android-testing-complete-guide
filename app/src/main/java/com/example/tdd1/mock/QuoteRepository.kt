package com.example.tdd1.mock

import com.example.tdd1.model.QUOTE_STATUS
import com.example.tdd1.model.Quote

class QuoteRepository {
    val quotes= listOf<Quote>(
        Quote("Do work","1"),
        Quote("hard","2"),
        Quote("daily","3"),

        )
    fun verifyQuote(quote: String, author: String):QUOTE_STATUS {
      //fetching from QuoteDB
        val selectedQuote= quotes.filter { quotes-> quotes.quote==quote }
        return if (selectedQuote.size==1){
            if (selectedQuote[0].author==author){
                 QUOTE_STATUS.SUCCESS
            }else{
                QUOTE_STATUS.INVALID_AUTHOR
            }
        }else{
                QUOTE_STATUS.INVALID_QUOTE
            }
        }


    }
