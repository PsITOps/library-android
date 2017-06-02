package pslibrary.booksactivity.adapter

import pslibrary.api.books.model.Book
import pslibrary.customview.adapter.AdapterContentType
import pslibrary.customview.adapter.ViewType

data class BookViewType(var book: Book,
                        var isAvailabilityIconVisible: Boolean) : ViewType {

    var onBookSelection: (book: Book) -> Unit = {}

    override fun getViewType(): Int = AdapterContentType.BOOKS.ordinal
}