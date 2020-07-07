package br.edu.unisep.nytimesbooks.ui.books

import android.os.Bundle
import android.view.View
import br.edu.unisep.nytimesbooks.data.local.BookDto
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.dialog_book_details.view.*

class BookDetailsDialog(private val book: BookDto) : BottomSheetDialogFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(view).load(book.imageUrl).into(view.imageViewCover)
    }

}