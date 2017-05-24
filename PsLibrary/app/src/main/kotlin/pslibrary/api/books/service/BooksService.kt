package pslibrary.api.books.service

import pslibrary.api.books.BooksApi
import pslibrary.api.books.BooksBackendApi

class BooksService(val booksBackendApi: BooksBackendApi) : BooksApi {

    override fun getBooks(userToken: String) =
            booksBackendApi.getBooks(userToken)

    override fun rentBook(bookId: String, userToken: String) =
            booksBackendApi.rentBook(bookId, userToken)
}