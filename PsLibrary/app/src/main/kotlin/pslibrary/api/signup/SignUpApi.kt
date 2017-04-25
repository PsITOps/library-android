package pslibrary.api.signup

import io.reactivex.Single
import pslibrary.api.signup.model.SignUpResponse

interface SignUpApi {

    fun signUp(name: String,
               lastname: String,
               login: String,
               password: String,
               librarianCode: String): Single<SignUpResponse>
}