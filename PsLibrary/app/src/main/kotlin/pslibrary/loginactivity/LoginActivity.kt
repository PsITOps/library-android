package com.ps.pslibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
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

        loginPresenter.context = this
        loginPresenter.attachView(this)

        setUpComponents()
    }

    private fun setUpComponents() {
        login_button.setOnClickListener {
            loginPresenter.startLogin(login_input.text.toString(), password_input.text.toString())
        }

        register_button.setOnClickListener {
            loginPresenter.openRegisterActivity()
        }
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(login_background)
    }

    override fun successLogin() {
        finish()
    }

    override fun showProgress() {
        login_button.text = ""
        login_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        login_button.text = getString(R.string.log_in_text)
        login_progress_bar.visibility = View.GONE
    }
}