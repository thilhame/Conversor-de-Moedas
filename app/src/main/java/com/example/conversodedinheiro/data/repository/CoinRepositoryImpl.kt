package com.example.conversodedinheiro.data.repository

import com.example.conversodedinheiro.core.exceptions.RemoteException
import com.example.conversodedinheiro.data.database.AppDataBase
import com.example.conversodedinheiro.data.model.ErrorResponse
import com.example.conversodedinheiro.data.model.WelcomeValue
import com.example.conversodedinheiro.data.services.AwesomeService
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class CoinRepositoryImpl(
     appDataBase: AppDataBase,
    private val service: AwesomeService

) :CoinRepository {
    private val dao = appDataBase.exchangeDao()

    override suspend fun getExchangeValue(coins: String)= flow {
        try {
            val exchangeValue =  service.exchangeValue(coins)
            val exchanger = exchangeValue.values.first()
            emit(exchanger)
        }catch (e:HttpException){
            val json = e.response()?.errorBody()?.string()
            //
            val errorResponse = Gson().fromJson(json,ErrorResponse::class.java)
            throw RemoteException(errorResponse.message)
        }
            }

    override suspend fun save(welcome: WelcomeValue) {
        dao.save(welcome)
    }

    override fun list(): Flow<List<WelcomeValue>> {
       return dao.findAll()
    }
}

