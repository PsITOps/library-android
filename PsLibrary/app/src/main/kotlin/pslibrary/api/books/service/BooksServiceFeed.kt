package pslibrary.api.books.service

import io.reactivex.Single
import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.BooksRetrofitApi
import pslibrary.api.books.model.AddBookBody
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.TokenBody

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

    override fun addNewBook(addBookBody: AddBookBody) =
            restAdapter().addNewBook(addBookBody)

    override fun getGenericParameter() = BooksRetrofitApi::class.java
}