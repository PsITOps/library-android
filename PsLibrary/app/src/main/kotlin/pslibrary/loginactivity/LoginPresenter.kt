package pslibrary.loginactivity

import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.login.LoginApi

class LoginPresenter(val loginApi: LoginApi) : BaseMvpPresenter<LoginView>() {

    lateinit var loginView: LoginView

    override fun attachView(view: LoginView) {
        super.attachView(view)
        loginView = view

        loginView.setBackground()
    }

    override fun detachView() {
        super.detachView()
    }
}