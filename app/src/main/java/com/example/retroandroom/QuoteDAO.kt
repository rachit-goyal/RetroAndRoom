package com.example.retroandroom

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface QuoteDao {

    @Insert
    suspend fun addQuotes(quotes: List<Result>)

    @Query("SELECT * FROM quote")
    suspend fun getQuotes() : List<Result>
}