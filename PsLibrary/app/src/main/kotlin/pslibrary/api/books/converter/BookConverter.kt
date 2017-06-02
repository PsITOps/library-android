package pslibrary.api.books.converter

import pslibrary.api.books.model.Book

object BookConverter {

    fun convertBookWithoutNullParams(bookList: List<Book>) : List<Book> {
        bookList.forEach {
            if (it.author == null) {
                it.author = ""
            }

            if (it.description == null) {
                it.description = ""
            }

            if (it.genre == null) {
                it.genre = ""
            }

            if (it.title == null) {
                it.title = ""
            }
        }
        return bookList
    }
}