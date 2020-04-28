package br.edu.unisep.covidreport.domain.repository

import br.edu.unisep.covidreport.data.service.factory.CovidServiceFactory
import br.edu.unisep.covidreport.domain.dto.CountryDto
import br.edu.unisep.covidreport.domain.dto.TotalDto

class CovidRepository {

    private val covidService = CovidServiceFactory.getCovidService()

    suspend fun getTotals(): TotalDto {
        val response = covidService.getTotals()
        val totalResponse = response.first()

        return TotalDto(
            totalResponse.confirmed,
            totalResponse.recovered,
            totalResponse.critical,
            totalResponse.deaths
        )
    }

    suspend fun getCountries(): List<CountryDto> {
        val response = covidService.listCountries()

        return response.map { country ->
            CountryDto(country.name, country.alpha2code)
        }
    }

}