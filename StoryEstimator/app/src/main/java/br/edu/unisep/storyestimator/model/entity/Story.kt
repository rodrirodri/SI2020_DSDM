package br.edu.unisep.storyestimator.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "stories")
data class Story(
    val title: String,
    val summary: String,
    val pointsDev1: Int,
    val pointsDev2: Int,
    val pointsDev3: Int,
    val pointsDev4: Int,
    val pointsAverage: Int,
    val priority: Int
) {
    @PrimaryKey
    var id: Int? = null
}