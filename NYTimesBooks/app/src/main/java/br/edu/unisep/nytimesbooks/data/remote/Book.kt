package br.edu.unisep.nytimesbooks.data.remote

data class Book(
    val rank: Int,
    val title: String,
    val description: String,
    val author: String,
    val publisher: String,
    val primary_isbn13: String,
    val primary_isbn10: String,
    val book_image: String
)