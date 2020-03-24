package br.edu.unisep.contactlist.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.edu.unisep.contactlist.R
import br.edu.unisep.contactlist.domain.dto.ContactDto
import kotlinx.android.synthetic.main.activity_list_contacts.*
import kotlinx.android.synthetic.main.activity_new_contact.*

class NewContactActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_contact)

        buttonNewContact.setOnClickListener { saveContact() }
    }

    private fun saveContact() {
        val name = editTextContactName.text.toString()
        val email = editTextContactEmail.text.toString()

        val contact = ContactDto(name, email)

        val resultIntent = Intent()
        resultIntent.putExtra("result-contact", contact)

        setResult(Activity.RESULT_OK, resultIntent)
        finish()
    }
}
