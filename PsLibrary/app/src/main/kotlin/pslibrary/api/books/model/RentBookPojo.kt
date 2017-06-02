package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

data class RentBookPojo(@SerializedName("valid") val valid: Boolean,
                        @SerializedName("message") val message: String,
                        @SerializedName("borrowedBook") val book: Book,
                        @SerializedName("returnDate") val returnDate: String)