package pslibrary.api.signup.service

import okhttp3.OkHttpClient
import pslibrary.api.DynamicUrlService
import pslibrary.api.signup.SignUpBackendApi
import pslibrary.api.signup.SignUpRetrofitApi

open class SignUpServiceFeed(client: OkHttpClient) :
        DynamicUrlService<SignUpRetrofitApi>(client = client), SignUpBackendApi {

    override fun signUp(name: String,
                        lastname: String,
                        login: String,
                        password: String,
                        librarianCode: String)
            = restAdapter().signUp(name, lastname, login, password, librarianCode)

    override fun getGenericParameter() = SignUpRetrofitApi::class.java
}