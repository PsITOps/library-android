package pslibrary.api.books.service

import io.reactivex.Single
import pslibrary.api.books.BooksApi
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.TokenBody

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
}