package br.edu.unisep.storyestimator.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.edu.unisep.storyestimator.model.entity.Story

@Dao
interface StoryDao {

    @Query("select * from stories")
    suspend fun findAll(): List<Story>

    @Insert
    suspend fun save(story: Story)
}