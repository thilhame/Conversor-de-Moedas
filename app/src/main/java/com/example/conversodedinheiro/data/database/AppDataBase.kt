package com.example.conversodedinheiro.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.conversodedinheiro.data.database.dao.ExchangeDao
import com.example.conversodedinheiro.data.model.WelcomeValue

@Database(entities = [WelcomeValue::class],version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun exchangeDao(): ExchangeDao

    companion object{
        fun getInstance(context: Context):AppDataBase{
            return Room.databaseBuilder(
                context.applicationContext,
                AppDataBase::class.java,
                "exchange_app_db"
            ).build()
        }
    }
}