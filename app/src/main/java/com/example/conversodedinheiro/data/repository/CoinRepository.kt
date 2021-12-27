package com.example.conversodedinheiro.data.repository

import com.example.conversodedinheiro.data.model.WelcomeValue
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    suspend fun getExchangeValue(coins: String): Flow<WelcomeValue>

    suspend fun save(welcome: WelcomeValue)
    fun list():Flow<List<WelcomeValue>>
}
