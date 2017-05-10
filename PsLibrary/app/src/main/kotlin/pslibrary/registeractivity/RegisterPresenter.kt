package pslibrary.registeractivity

import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.signup.SignUpApi

class RegisterPresenter(val signUpApi: SignUpApi,
                        val scheduler: ApplicationScheduler) : BaseMvpPresenter<RegisterView>() {

    lateinit var registerView: RegisterView

    override fun attachView(view: RegisterView) {
        super.attachView(view)
        registerView = view

        registerView.setBackground()
    }

    override fun detachView() {
        super.detachView()
    }

    fun register(name: String,
                 lastName: String,
                 username: String,
                 password: String,
                 librarianCode: String?) {
        registerView.showProgress()
        scheduler.schedule(signUpApi.signUp(name, lastName, username, password, librarianCode),
                {
                    registerView.hideProgress()
                    if (it.valid) {
                        registerView.successfulRegister()
                    } else {
                        registerView.showError(it.message)
                    }
                },
                {
                    registerView.showError("There is problem with internet connection or service has been disabled")
                    registerView.hideProgress()
                },
                this)
    }
}