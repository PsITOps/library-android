
package pslibrary.api.books

import io.reactivex.Single
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.BorrowedBookPojo

interface BooksApi {

    fun getBooks(userToken: String) : Single<BooksListPojo>

    fun rentBook(bookId: String, userToken: String) : Single<BorrowedBookPojo>

    fun getMyBooks(userToken: String) : Single<BooksListPojo>
}