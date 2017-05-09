package pslibrary.api.login

import io.reactivex.Single
import pslibrary.api.login.model.LoginBody
import pslibrary.api.login.model.LoginPojo
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitApi {

    @POST("/signin")
    fun signIn(@Body loginBody: LoginBody) : Single<LoginPojo>
}