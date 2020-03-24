package br.edu.unisep.contactlist.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import br.edu.unisep.contactlist.R
import br.edu.unisep.contactlist.ui.adapter.ListContactAdapter
import kotlinx.android.synthetic.main.activity_list_contacts.*

class ListContactsActivity : AppCompatActivity() {

    private val adapter = ListContactAdapter()

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
}
