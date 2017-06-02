package pslibrary.api.books.service

import io.reactivex.Single
import pslibrary.api.books.BooksApi
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.model.BooksListPojo

class BooksService(val booksBackendApi: BooksBackendApi) : BooksApi {

    override fun getMyBooks(userToken: String): Single<BooksListPojo> =
            booksBackendApi.getMyBooks(userToken)

    override fun getBooks(userToken: String) =
            booksBackendApi.getBooks(userToken)

    override fun rentBook(bookId: String, userToken: String) =
            booksBackendApi.rentBook(bookId, userToken)
}