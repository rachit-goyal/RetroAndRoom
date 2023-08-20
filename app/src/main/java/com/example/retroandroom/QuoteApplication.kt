package com.example.retroandroom

import android.app.Application

class QuoteApplication : Application() {

    lateinit var repository: QuoteRepository
    override fun onCreate() {
        super.onCreate()
        val quotesAPI = RetrofitHelper.getInstance().create(QuoteAPI::class.java)
        val quoteDatabase = QuoteDatabase.getDatabase(applicationContext)
        repository = QuoteRepository(quotesAPI, quoteDatabase,applicationContext)

    }
}