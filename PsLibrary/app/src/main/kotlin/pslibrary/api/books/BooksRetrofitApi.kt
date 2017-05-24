package pslibrary.api.books

import io.reactivex.Single
import pslibrary.api.books.model.BooksListPojo
import pslibrary.api.books.model.BorrowedBookPojo
import retrofit2.http.*

interface BooksRetrofitApi {

    @GET("/api/books")
    fun getBooks(@Header("x-access-token") token : String) : Single<BooksListPojo>

    @POST("/api/books/{id|/rent")
    fun rentBook(@Path("id") id: String,
                 @Header("x-access-token") token: String) : Single<BorrowedBookPojo>
}