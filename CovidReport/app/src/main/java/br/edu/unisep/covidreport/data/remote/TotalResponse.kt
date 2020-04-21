package br.edu.unisep.covidreport.data.remote

data class TotalResponse(
    val confirmed: Long,
    val recovered: Long,
    val critical: Long,
    val deaths: Long
)