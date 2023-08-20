package com.example.retroandroom

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>
}