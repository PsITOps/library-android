package pslibrary.loginactivity

import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.login.LoginApi

class LoginPresenter(val loginApi: LoginApi,
                     val scheduler: ApplicationScheduler) : BaseMvpPresenter<LoginView>() {

    lateinit var loginView: LoginView

    override fun attachView(view: LoginView) {
        super.attachView(view)
        loginView = view

        loginView.setBackground()
    }

    override fun detachView() {
        super.detachView()
    }

    fun startLogin(login: String, password: String) {
        loginView.showProgress()
        scheduler.schedule(loginApi.signIn(login, password),
                { loginView.successLogin() },
                { loginView.hideProgress() },
                this)
    }
}