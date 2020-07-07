package br.edu.unisep.nytimesbooks.data.remote

data class BookListResponse(
    val status: String,
    val results: BookListResults
)