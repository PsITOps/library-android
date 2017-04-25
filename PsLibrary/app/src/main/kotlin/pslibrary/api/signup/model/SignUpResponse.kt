package pslibrary.api.signup.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(@SerializedName("valid") val valid: Boolean,
                          @SerializedName("isLibrarian") val isLibrarian: Boolean,
                          @SerializedName("message") val message: String)