package pslibrary.registeractivity

import android.content.Context
import com.ps.pslibrary.R
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.signup.SignUpApi
import pslibrary.customview.DialogProvider

class RegisterPresenter(val signUpApi: SignUpApi,
                        val scheduler: ApplicationScheduler,
                        val dialogProvider: DialogProvider) : BaseMvpPresenter<RegisterView>() {

    lateinit var registerView: RegisterView
    lateinit var context: Context

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
                        dialogProvider.showSuccessDialog(context, context.getString(R.string.register_success_dialog), onSuccessDialog(), onSuccessDialog())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onErrorButton())
                    }
                },
                {
                    registerView.hideProgress()
                    dialogProvider.showErrorDialog(context, context.getString(R.string.register_error_dialog), onErrorButton())
                },
                this)
    }

    private fun onSuccessDialog() = {
        registerView.successfulRegister()
    }

    private fun onErrorButton() = {
        dialogProvider.dismissDialog()
    }
}