package br.edu.unisep.todo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import br.edu.unisep.todo.data.dao.TaskDao
import br.edu.unisep.todo.data.entity.Task

@Database(
    entities = [ Task::class ],
    exportSchema = false,
    version = 1
)
abstract class ToDoDb : RoomDatabase() {

    abstract fun getTaskDao(): TaskDao


    companion object {

        private lateinit var instance: ToDoDb

    }
}