package pslibrary.api.books.model

import com.google.gson.annotations.SerializedName

data class Book(@SerializedName("_id") val id : String,
                @SerializedName("name") val name: String,
                @SerializedName("genre") val genre: String,
                @SerializedName("author") val author: String,
                @SerializedName("Description") val description: String = "",
                @SerializedName("isAvailable") val isAvailable: Boolean)