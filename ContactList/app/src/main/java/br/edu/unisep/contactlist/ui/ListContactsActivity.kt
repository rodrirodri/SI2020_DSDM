package br.edu.unisep.contactlist.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.contactlist.R
import br.edu.unisep.contactlist.domain.dto.ContactDto
import br.edu.unisep.contactlist.ui.adapter.ListContactAdapter
import br.edu.unisep.contactlist.ui.viewmodel.ListContactsViewModel
import kotlinx.android.synthetic.main.activity_list_contacts.*

class ListContactsActivity : AppCompatActivity() {

    private val adapter = ListContactAdapter(this::removeContact)

    private val viewModel: ListContactsViewModel by lazy {
        ViewModelProvider(this).get(ListContactsViewModel::class.java)
    }

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

        viewModel.contacts.observe(this, Observer { allContacts ->
            adapter.updateContacts(allContacts)
        })
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
                viewModel.save(contact)
            }
        }
    }

    private fun removeContact(contact: ContactDto) {
        viewModel.delete(contact)
    }

}
