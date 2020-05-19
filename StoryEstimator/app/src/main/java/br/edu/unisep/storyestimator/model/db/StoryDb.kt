package br.edu.unisep.storyestimator.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.edu.unisep.storyestimator.model.dao.StoryDao
import br.edu.unisep.storyestimator.model.entity.Story

@Database(
    entities = [Story::class],
    exportSchema = false,
    version = 1
)
abstract class StoryDb : RoomDatabase(){

    abstract fun getStoryDao(): StoryDao

    companion object {
        private lateinit var instance: StoryDb

        fun createInstance(context: Context) {
            instance = Room.databaseBuilder(context, StoryDb::class.java, "db_stories").build()
        }

        fun getInstance() = instance
    }
}