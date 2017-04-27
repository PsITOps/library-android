package pslibrary.api.login.service

import pslibrary.api.login.LoginApi
import pslibrary.api.login.LoginBackendApi

class LoginService(val loginBackendApi: LoginBackendApi) : LoginApi {

    override fun signIn(login: String, password: String)
            = loginBackendApi.signIn(login, password)
}