package com.example.conversodedinheiro.data.services

import com.example.conversodedinheiro.data.model.Welcome
import com.example.conversodedinheiro.data.model.WelcomeValue
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path

interface AwesomeService {

    @GET("/json/last/{moedas}")
    suspend fun exchangeValue(@Path("moedas") moedas: String ): Welcome
}