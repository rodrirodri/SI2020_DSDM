package br.edu.unisep.myexpenses.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.myexpenses.model.dao.ExpenseDao
import br.edu.unisep.myexpenses.model.entity.Expense

@Database(
    entities = [Expense::class],
    exportSchema = false,
    version = 1
)
abstract class ExpenseDb : RoomDatabase() {

    abstract fun getExpenseDao(): ExpenseDao

    companion object {

        private lateinit var instance: ExpenseDb

        fun createInstance(context: Context) {
            instance = Room.databaseBuilder(context, ExpenseDb::class.java, "db_expenses").build()
        }

        fun getInstance() = instance
    }
}