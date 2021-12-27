package com.example.conversodedinheiro.domain.di

import com.example.conversodedinheiro.domain.GetExchangeValueUseCase
import com.example.conversodedinheiro.domain.ListExchangeUseCase
import com.example.conversodedinheiro.domain.SaveExchangeUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {
    fun load(){
        loadKoinModules(useCasemodule())
    }

    private fun useCasemodule(): Module {
        return module {
            factory { ListExchangeUseCase(get()) }
            factory { SaveExchangeUseCase(get()) }
            factory { GetExchangeValueUseCase(get()) }
        }

    }
}