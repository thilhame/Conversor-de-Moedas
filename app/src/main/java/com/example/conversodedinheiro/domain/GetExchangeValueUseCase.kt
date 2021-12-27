package com.example.conversodedinheiro.domain

import com.example.conversodedinheiro.core.UseCase
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class GetExchangeValueUseCase(
    private val repository: CoinRepository
): UseCase<String, WelcomeValue>() {

    override suspend fun execute(param: String):
            Flow<WelcomeValue> {
        return repository.getExchangeValue(param)
    }
}