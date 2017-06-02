package pslibrary.api.books.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Book(@SerializedName("_id") var id : String,
                @SerializedName("title") var title: String?,
                @SerializedName("genre") var genre: String?,
                @SerializedName("author") var author: String?,
                @SerializedName("description") var description: String?,
                @SerializedName("isAvailable") var isAvailable: Boolean) : Parcelable {

    companion object {
        @JvmField val CREATOR: Parcelable.Creator<Book> = object : Parcelable.Creator<Book> {
            override fun createFromParcel(source: Parcel): Book = Book(source)
            override fun newArray(size: Int): Array<Book?> = arrayOfNulls(size)
        }
    }

    constructor(source: Parcel) : this(
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString(),
    source.readString() ?: "",
    1 == source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(title)
        dest.writeString(genre)
        dest.writeString(author)
        dest.writeString(description ?: "")
        dest.writeInt((if (isAvailable) 1 else 0))
    }
}