package com.example.conversodedinheiro.data.database.dao

import androidx.room.*
import com.example.conversodedinheiro.data.model.WelcomeValue
import kotlinx.coroutines.flow.Flow

@Dao
interface ExchangeDao {
  @Query("SELECT * FROM tb_exchange")
  fun findAll(): Flow<List<WelcomeValue>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  suspend fun save(entity: WelcomeValue)

}