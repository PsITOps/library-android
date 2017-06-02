package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

data class AddBookBody(@SerializedName("title") val title: String,
                       @SerializedName("genre") val genre: String,
                       @SerializedName("author") val author: String,
                       @SerializedName("description") val description: String,
                       @SerializedName("token") val token: String)