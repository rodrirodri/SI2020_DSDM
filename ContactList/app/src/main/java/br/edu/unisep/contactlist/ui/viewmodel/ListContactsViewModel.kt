package br.edu.unisep.contactlist.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.edu.unisep.contactlist.domain.dto.ContactDto

class ListContactsViewModel : ViewModel() {

    private val allContacts = mutableListOf<ContactDto>()

    val contacts = MutableLiveData< List<ContactDto> >()

    fun save(contact: ContactDto) {
        allContacts.add(contact)
        contacts.postValue(allContacts)
    }

    fun delete(contact: ContactDto) {
        allContacts.remove(contact)
        contacts.postValue(allContacts)
    }

}