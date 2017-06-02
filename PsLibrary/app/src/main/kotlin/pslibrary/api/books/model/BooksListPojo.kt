package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

data class BooksListPojo(@SerializedName("books") val bookList: List<Book>,
                         @SerializedName("valid") val valid: Boolean,
                         @SerializedName("message") val message: String)