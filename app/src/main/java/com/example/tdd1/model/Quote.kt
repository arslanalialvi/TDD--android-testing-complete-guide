package com.example.tdd1.model

data class Quote(val quote: String, val author: String)
enum class QUOTE_STATUS{
    INVALID_QUOTE,
    INVALID_AUTHOR,
    UNKNOWN_ERROR,
    SUCCESS
}