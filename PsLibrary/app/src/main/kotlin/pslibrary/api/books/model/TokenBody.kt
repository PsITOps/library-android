package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

class TokenBody(@SerializedName("token") val token: String) {
}