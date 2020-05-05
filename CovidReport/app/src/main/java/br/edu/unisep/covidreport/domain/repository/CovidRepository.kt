package br.edu.unisep.covidreport.domain.repository

import br.edu.unisep.covidreport.data.service.factory.CovidServiceFactory
import br.edu.unisep.covidreport.domain.base.ApiResult
import br.edu.unisep.covidreport.domain.base.ResultError
import br.edu.unisep.covidreport.domain.base.ResultSuccess
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.domain.dto.TotalDto

class CovidRepository {

    private val covidService = CovidServiceFactory.getCovidService()

    suspend fun getTotals(): ApiResult {
        return try {
            val response = covidService.getTotals()
            val totalResponse = response.first()

            ResultSuccess(
                TotalDto(
                    totalResponse.confirmed,
                    totalResponse.recovered,
                    totalResponse.critical,
                    totalResponse.deaths
                )
            )
        } catch (e: Exception) {
            ResultError()
        }
    }

    suspend fun getCountries(): ApiResult {
        return try {
            val response = covidService.listCountries()

            ResultSuccess(response.map { country ->
                CountryDto(country.name, country.alpha2code)
            })
        } catch (e: Exception) {
            ResultError()
        }
    }
}