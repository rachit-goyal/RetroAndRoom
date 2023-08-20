package com.example.retroandroom

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class QuoteRepository(private val quoteAPI: QuoteAPI,private val quoteDatabase: QuoteDatabase,private val context: Context) {

    private val quoteLiveData = MutableLiveData<QuoteList>()
    val quotes: LiveData<QuoteList>
        get() = quoteLiveData

    suspend fun getQuote(page: Int) {

        if(NetworkUtils.isInternetAvailable(context)){
            val result = quoteAPI.getQuotes(page)
            if (result.body() != null) {
                quoteDatabase.quoteDao().addQuotes(result.body()!!.results)
                quoteLiveData.postValue(result.body())
            }
        }
        else{
            val quotes=quoteDatabase.quoteDao().getQuotes()
            val quoteList=QuoteList(1,1,1,quotes,1,1)
            quoteLiveData.postValue(quoteList)
        }


    }
}