package br.edu.unisep.covidreport.domain.base

sealed class ApiResult

data class ResultSuccess<T>(val result: T) : ApiResult()

class ResultError : ApiResult()