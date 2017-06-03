package pslibrary.api.books.service

import io.reactivex.Single
import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.BooksRetrofitApi
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.TokenBody
import pslibrary.api.books.model.bookBody

class BooksServiceFeed(client: OkHttpClient) :
        DynamicUrlService<BooksRetrofitApi>(client = client), BooksBackendApi {

    override fun getMyBooks(userToken: String): Single<BooksListPojo> =
            restAdapter().getMyBooks(userToken)

    override fun getBooks(userToken: String) =
            restAdapter().getBooks(userToken)

    override fun rentBook(bookId: String, tokenBody: TokenBody) =
            restAdapter().rentBook(bookId, tokenBody)

    override fun rentMoreBook(bookId: String, tokenBody: TokenBody) =
            restAdapter().rentMoreBook(bookId, tokenBody)

    override fun returnBook(bookId: String, tokenBody: TokenBody) =
            restAdapter().returnBook(bookId, tokenBody)

    override fun addNewBook(bookBody: bookBody) =
            restAdapter().addNewBook(bookBody)

    override fun deleteBook(bookId: String, tokenBody: TokenBody) =
            restAdapter().deleteBook(bookId, tokenBody)

    override fun editBook(bookId: String, bookBody: bookBody) =
            restAdapter().editBook(bookId, bookBody)

    override fun getGenericParameter() = BooksRetrofitApi::class.java
}