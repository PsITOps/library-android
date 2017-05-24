package pslibrary.api.login.model

import com.google.gson.annotations.SerializedName

data class LoginPojo(@SerializedName("token") val token: String,
                     @SerializedName("isLibrarian") val isLibrarian: Boolean,
                     @SerializedName("valid") val valid: Boolean,
                     @SerializedName("message") val message: String)