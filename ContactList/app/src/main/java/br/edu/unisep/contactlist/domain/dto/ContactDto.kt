package br.edu.unisep.contactlist.domain.dto

import java.io.Serializable

data class ContactDto(val name: String,
                      val email: String) : Serializable