package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

data class RentMoreBookPojo(@SerializedName("valid") val valid: Boolean,
                            @SerializedName("message") val message: String)
