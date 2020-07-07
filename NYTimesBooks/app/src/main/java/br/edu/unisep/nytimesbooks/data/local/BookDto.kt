package br.edu.unisep.nytimesbooks.data.local

data class BookDto(
    val rank: Int,
    val title: String,
    val description: String,
    val author: String,
    val publisher: String,
    val imageUrl: String
)