package br.edu.unisep.myexpenses.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.unisep.myexpenses.model.entity.Expense

@Dao
interface ExpenseDao {

    @Insert
    suspend fun save(expense: Expense)

    @Query("select * from expense")
    suspend fun findAll(): List<Expense>

}