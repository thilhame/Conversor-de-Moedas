package com.example.conversodedinheiro.domain

import com.example.conversodedinheiro.core.UseCase
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow

class ListExchangeUseCase(
    private val repository: CoinRepository
):UseCase.NoParam<List<WelcomeValue>>() {

    override suspend fun execute(): Flow<List<WelcomeValue>> {
        return repository.list()
    }
}