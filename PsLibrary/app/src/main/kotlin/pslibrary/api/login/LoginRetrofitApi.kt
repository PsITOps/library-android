package pslibrary.api.login

import io.reactivex.Single
import pslibrary.api.login.model.LoginPojo
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitApi {

    @POST
    fun signIn(@Body login: String,
               @Body password: String) : Single<LoginPojo>
}