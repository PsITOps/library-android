package pslibrary.api.signup

import io.reactivex.Single
import pslibrary.api.signup.model.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitApi {

    @POST
    fun signUp(@Body name: String,
               @Body lastname: String,
               @Body login: String,
               @Body password: String,
               @Body librarianCode: String): Single<SignUpResponse>
}