package br.edu.unisep.nytimesbooks.data.local

import java.io.Serializable

data class CategoryDto(
    val displayName: String,
    val encodedName: String
) : Serializable