package pslibrary.loginactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import com.ps.pslibrary.navigator.Navigator
import pslibrary.api.login.LoginApi
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class LoginPresenter(val loginApi: LoginApi,
                     val navigator: Navigator,
                     val scheduler: ApplicationScheduler,
                     val dialogProvider: DialogProvider,
                     val userProvider: UserProvider) : BaseMvpPresenter<LoginView>() {

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
                {
                    loginView.hideProgress()
                    if (it.valid) {
                        userProvider.setLibrarian(it.isLibrarian)
                        userProvider.setUserToken(it.token)
                        loginView.successLogin()
                        openBooksActivity()
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onErrorButton())
                    }
                },
                { loginView.hideProgress() },
                this)
    }

    fun openBooksActivity() {
        navigator.openBooksActivity(context)
    }

    fun openRegisterActivity() {
        navigator.openRegisterActivity(context)
    }

    private fun onErrorButton() = {
        dialogProvider.dismissDialog()
    }
}