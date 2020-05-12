package br.edu.unisep.myexpenses.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "expense")
data class Expense(
    var description: String,
    var date: String,
    var value: Double
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}