package br.edu.unisep.todo.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.unisep.todo.data.entity.Task

@Dao
interface TaskDao {

    @Insert
    suspend fun save(task: Task)

    @Query("select * from task")
    suspend fun findAll(): List<Task>

}