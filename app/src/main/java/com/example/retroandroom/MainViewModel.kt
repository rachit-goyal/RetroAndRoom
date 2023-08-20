package com.example.retroandroom

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val quoteRepository: QuoteRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            quoteRepository.getQuote(1)
        }
    }

    val quotes:LiveData<QuoteList>
    get()=quoteRepository.quotes
}