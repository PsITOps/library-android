package com.ps.pslibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_login.*
import pslibrary.loginactivity.LoginPresenter
import pslibrary.loginactivity.LoginView
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginView {

    @Inject
    lateinit var loginPresenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginPresenter.attachView(this)
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_login_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(login_background)
    }

    override fun successLogin() {

    }

    override fun failLogin() {

    }
}