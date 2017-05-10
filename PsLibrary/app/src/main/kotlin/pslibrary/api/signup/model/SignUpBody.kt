package pslibrary.api.signup.model

import com.google.gson.annotations.SerializedName

data class SignUpBody(@SerializedName("name") val name: String,
                      @SerializedName("lastname") val lastname: String,
                      @SerializedName("login") val login: String,
                      @SerializedName("password") val password: String,
                      @SerializedName("librarianCode") val librarianCode: String?)