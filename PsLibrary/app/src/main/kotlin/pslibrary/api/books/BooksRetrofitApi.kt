package pslibrary.api.books

import io.reactivex.Single
import pslibrary.api.books.model.*
import retrofit2.http.*

interface BooksRetrofitApi {

    @GET("/api/books")
    fun getBooks(@Header("x-access-token") token: String): Single<BooksListPojo>

    @POST("/api/books/{id}/rent")
    fun rentBook(@Path("id") id: String,
                 @Body tokenBody: TokenBody): Single<RentBookPojo>

    @POST("api/books/{id}/rent/extend")
    fun rentMoreBook(@Path("id") id: String,
                     @Body tokenBody: TokenBody): Single<RentMoreBookPojo>

    @POST("api/books/{id}/return")
    fun returnBook(@Path("id") id: String,
                   @Body tokenBody: TokenBody): Single<BookReturnPojo>

    @GET("api/account/books")
    fun getMyBooks(@Header("x-access-token") token: String): Single<BooksListPojo>


}