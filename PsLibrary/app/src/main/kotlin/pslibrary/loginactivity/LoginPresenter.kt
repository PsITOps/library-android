package pslibrary.loginactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import com.ps.pslibrary.navigator.Navigator
import pslibrary.api.login.LoginApi

class LoginPresenter(val loginApi: LoginApi,
                     val navigator: Navigator,
                     val scheduler: ApplicationScheduler) : BaseMvpPresenter<LoginView>() {

    lateinit var loginView: LoginView
    lateinit var context: Context

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

    fun openRegisterActivity() {
        navigator.openRegisterActivity(context)
    }
}