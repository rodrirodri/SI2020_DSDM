package br.edu.unisep.storyestimator.app

import android.app.Application
import br.edu.unisep.storyestimator.model.db.StoryDb

class StoriesApp : Application() {

    override fun onCreate() {
        super.onCreate()
        StoryDb.createInstance(applicationContext)
    }

}