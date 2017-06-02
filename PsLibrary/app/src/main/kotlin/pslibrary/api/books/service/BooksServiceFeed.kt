package pslibrary.api.books.service

import io.reactivex.Single
import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.BooksRetrofitApi
import pslibrary.api.books.model.BooksListPojo

class BooksServiceFeed(client: OkHttpClient) :
        DynamicUrlService<BooksRetrofitApi>(client = client), BooksBackendApi {

    override fun getMyBooks(userToken: String): Single<BooksListPojo> =
            restAdapter().getMyBooks(userToken)

    override fun getBooks(userToken: String) =
            restAdapter().getBooks(userToken)

    override fun rentBook(bookId: String, userToken: String) =
            restAdapter().rentBook(bookId, userToken)

    override fun getGenericParameter() = BooksRetrofitApi::class.java
}