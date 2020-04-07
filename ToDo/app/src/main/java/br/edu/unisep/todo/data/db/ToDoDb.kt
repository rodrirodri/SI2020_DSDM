package br.edu.unisep.todo.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.todo.data.dao.TaskDao
import br.edu.unisep.todo.data.entity.Task

@Database(
    entities = [Task::class],
    exportSchema = false,
    version = 1
)
abstract class ToDoDb : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao

    companion object {
        private const val DB_NAME = "db_todo"

        private lateinit var instance: ToDoDb

        fun createInstance(context: Context) {
            instance = Room.databaseBuilder(context, ToDoDb::class.java, DB_NAME).build()
        }

        fun getInstance() = instance
    }
}