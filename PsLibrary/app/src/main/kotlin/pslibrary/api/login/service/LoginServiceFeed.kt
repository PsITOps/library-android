package pslibrary.api.login.service

import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.login.LoginBackendApi
import pslibrary.api.login.LoginRetrofitApi
import pslibrary.api.login.model.LoginBody

class LoginServiceFeed(client: OkHttpClient) :
        DynamicUrlService<LoginRetrofitApi>(client = client), LoginBackendApi {

    override fun signIn(login: String, password: String)
            = restAdapter().signIn(LoginBody(login, password))

    override fun getGenericParameter() = LoginRetrofitApi::class.java

}

