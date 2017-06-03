
package pslibrary.api.books

import io.reactivex.Single
import pslibrary.api.books.model.*

interface BooksApi {

    fun getBooks(userToken: String) : Single<BooksListPojo>

    fun rentBook(bookId: String, tokenBody: TokenBody) : Single<RentBookPojo>

    fun rentMoreBook(bookId: String, tokenBody: TokenBody) : Single<RentMoreBookPojo>

    fun returnBook(bookId: String, tokenBody: TokenBody) : Single<BookReturnPojo>

    fun getMyBooks(userToken: String) : Single<BooksListPojo>

    fun addNewBook(bookBody: bookBody): Single<StandardBookPojo>

    fun deleteBook(bookId: String, tokenBody: TokenBody) : Single<StandardBookPojo>

    fun editBook(bookId: String, bookBody: bookBody): Single<StandardBookPojo>
}