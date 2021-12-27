package com.example.conversodedinheiro.domain

import com.example.conversodedinheiro.core.UseCase
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.data.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class SaveExchangeUseCase(
    private val repository: CoinRepository
):UseCase.NoSource<WelcomeValue>() {

    override suspend fun execute(param: WelcomeValue): Flow<Unit> {
        return flow {
            repository.save(param)
            emit(Unit)
        }
    }
}