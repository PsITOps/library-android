package pslibrary.api.books

import io.reactivex.Single
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.BorrowedBookPojo

interface BooksBackendApi {

    fun getBooks(userToken: String) : Single<BooksListPojo>

    fun rentBook(bookId: String, userToken: String) : Single<BorrowedBookPojo>
}