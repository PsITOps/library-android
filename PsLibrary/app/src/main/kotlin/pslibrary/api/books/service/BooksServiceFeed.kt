package pslibrary.api.books.service

import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.books.BooksBackendApi
import pslibrary.api.books.BooksRetrofitApi

class BooksServiceFeed(client: OkHttpClient) :
        DynamicUrlService<BooksRetrofitApi>(client = client), BooksBackendApi {

    override fun getBooks(userToken: String) =
            restAdapter().getBooks(userToken)

    override fun rentBook(bookId: String, userToken: String) =
            restAdapter().rentBook(bookId, userToken)

    override fun getGenericParameter() = BooksRetrofitApi::class.java
}