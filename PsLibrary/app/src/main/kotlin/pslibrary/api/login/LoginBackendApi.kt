package pslibrary.api.login

import io.reactivex.Single
import pslibrary.api.login.model.LoginPojo

interface LoginBackendApi {

    fun signIn(login: String,
               password: String) : Single<LoginPojo>
}