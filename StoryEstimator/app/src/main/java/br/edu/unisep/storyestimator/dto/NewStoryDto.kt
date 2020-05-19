package br.edu.unisep.storyestimator.dto

data class NewStoryDto(
    val title: String,
    val summary: String,
    val pointsDev1: Int,
    val pointsDev2: Int,
    val pointsDev3: Int,
    val pointsDev4: Int,
    val pointsAverage: Int,
    val priority: Int
)