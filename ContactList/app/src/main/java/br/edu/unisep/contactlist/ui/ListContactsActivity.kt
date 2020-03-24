package br.edu.unisep.contactlist.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.contactlist.R
import br.edu.unisep.contactlist.domain.dto.ContactDto
import br.edu.unisep.contactlist.ui.adapter.ListContactAdapter
import kotlinx.android.synthetic.main.activity_list_contacts.*

class ListContactsActivity : AppCompatActivity() {

    private val adapter = ListContactAdapter()
    private val allContacts = mutableListOf<ContactDto>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_contacts)

        setupList()
        setupEvents()
    }

    private fun setupList() {
        listContacts.layoutManager = LinearLayoutManager(this)
        listContacts.adapter = adapter

        listContacts.addItemDecoration(DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL))
    }

    private fun setupEvents() {
        buttonNewContact.setOnClickListener {
            openNewContact()
        }
    }

    private fun openNewContact() {
        val intentNewContact = Intent(this, NewContactActivity::class.java)
        startActivityForResult(intentNewContact, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Request code == 1 indica que voltou da NewContactActivity
        if (requestCode == 1) {
            val contact = data?.getSerializableExtra("result-contact") as? ContactDto

            if (contact != null) {
                allContacts.add(contact)
                adapter.updateContacts(allContacts)
            }
        }
    }
}
