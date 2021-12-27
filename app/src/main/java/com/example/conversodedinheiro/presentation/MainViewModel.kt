package com.example.conversodedinheiro.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.domain.GetExchangeValueUseCase
import com.example.conversodedinheiro.domain.SaveExchangeUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MainViewModel(
    private val saveExchangeUseCase: SaveExchangeUseCase,
    private val getExchangeValueUseCase: GetExchangeValueUseCase
) : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun getExchangeValue(coins: String) {
        viewModelScope.launch {
            getExchangeValueUseCase(coins)
                .flowOn(Dispatchers.Main)
                .onStart {
                    _state.value = State.Loading
                }
                .catch {
                   _state.value = State.Error(it)
                }
                .collect {
                _state.value = State.Sucess(it)              }
        }
    }

    fun saveExchange(exchange: WelcomeValue) {
        viewModelScope.launch {
            saveExchangeUseCase(exchange)
                .flowOn(Dispatchers.Main)
                .onStart {
                    _state.value = State.Loading
                }
                .catch {
                    _state.value = State.Error(it)
                }
                .collect {
                    _state.value = State.Saved             }
        }
    }

    sealed class State{
        object Loading: State()
        object Saved: State()

        data class Sucess(val exchange: WelcomeValue):State()
        data class Error(val throwable: Throwable):State()
    }
}