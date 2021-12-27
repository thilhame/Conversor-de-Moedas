package com.example.conversodedinheiro.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


typealias Welcome = HashMap<String, WelcomeValue>

@Entity(tableName = "tb_exchange")
data class WelcomeValue (
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    val code: String,
    val codein: String,
    val name: String,
    val bid: Double
)

