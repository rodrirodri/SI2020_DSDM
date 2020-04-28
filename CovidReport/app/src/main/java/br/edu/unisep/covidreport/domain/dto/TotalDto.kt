package br.edu.unisep.covidreport.domain.dto

data class TotalDto(
    val confirmed: Long,
    val recovered: Long,
    val critical: Long,
    val deaths: Long
)