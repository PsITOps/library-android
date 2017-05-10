package pslibrary.api.signup.service

import io.reactivex.Single
import pslibrary.api.signup.SignUpApi
import pslibrary.api.signup.SignUpBackendApi
import pslibrary.api.signup.model.SignUpResponse

class SignUpService(val signUpBackendApi: SignUpBackendApi) : SignUpApi {

    override fun signUp(name: String,
                        lastname: String,
                        login: String,
                        password: String,
                        librarianCode: String?): Single<SignUpResponse>
            = signUpBackendApi.signUp(name, lastname, login, password, librarianCode)
}