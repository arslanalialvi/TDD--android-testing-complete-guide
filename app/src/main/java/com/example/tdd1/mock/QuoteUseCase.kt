package com.example.tdd1.mock

import com.example.tdd1.model.QUOTE_STATUS
import com.example.tdd1.model.Quote

class QuoteUseCase(private val quoteRepository: QuoteRepository) {
    fun verifyQuote(quote: String, author: String): String{
        val status= quoteRepository.verifyQuote(quote,author)
        return when(status){
            QUOTE_STATUS.INVALID_QUOTE-> "Quote not exist."
            QUOTE_STATUS.INVALID_AUTHOR->"Author is invalid."
            QUOTE_STATUS.UNKNOWN_ERROR->"Unknown error occurred."
            QUOTE_STATUS.SUCCESS->"Quote is valid."
        }
    }
}