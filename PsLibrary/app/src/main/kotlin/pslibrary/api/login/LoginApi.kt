package pslibrary.api.login

import io.reactivex.Single
import pslibrary.api.login.model.LoginPojo

interface LoginApi {

    fun signIn(login: String,
               password: String): Single<LoginPojo>
}