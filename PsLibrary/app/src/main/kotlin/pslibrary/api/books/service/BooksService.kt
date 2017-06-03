package pslibrary.api.books.service

import io.reactivex.Single
import pslibrary.api.books.BooksApi
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.TokenBody
import pslibrary.api.books.model.bookBody

class BooksService(val booksBackendApi: BooksBackendApi) : BooksApi {

    override fun getMyBooks(userToken: String): Single<BooksListPojo> =
            booksBackendApi.getMyBooks(userToken)

    override fun getBooks(userToken: String) =
            booksBackendApi.getBooks(userToken)

    override fun rentMoreBook(bookId: String, tokenBody: TokenBody) =
            booksBackendApi.rentMoreBook(bookId, tokenBody)

    override fun returnBook(bookId: String, tokenBody: TokenBody) =
            booksBackendApi.returnBook(bookId, tokenBody)

    override fun rentBook(bookId: String, tokenBody: TokenBody) =
            booksBackendApi.rentBook(bookId, tokenBody)

    override fun addNewBook(bookBody: bookBody) =
            booksBackendApi.addNewBook(bookBody)

    override fun deleteBook(bookId: String, tokenBody: TokenBody) =
            booksBackendApi.deleteBook(bookId, tokenBody)

    override fun editBook(bookId: String, bookBody: bookBody) =
            booksBackendApi.editBook(bookId, bookBody)
}