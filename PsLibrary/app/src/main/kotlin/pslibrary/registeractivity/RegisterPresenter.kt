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
                 librarianCode: String) {
        scheduler.schedule(signUpApi.signUp(name, lastName, username, password, librarianCode),
                {},
                {},
                this)
    }
}