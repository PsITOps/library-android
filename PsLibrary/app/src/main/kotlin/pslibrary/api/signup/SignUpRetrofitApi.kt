package pslibrary.api.signup

import io.reactivex.Single
import pslibrary.api.signup.model.SignUpBody
import pslibrary.api.signup.model.SignUpResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitApi {

    @POST("/signup")
    fun signUp(@Body signUpBody: SignUpBody): Single<SignUpResponse>
}