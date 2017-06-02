package pslibrary.registeractivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_register.*
import pslibrary.customview.DialogProvider
import javax.inject.Inject

class RegisterActivity : AppCompatActivity(), RegisterView {

    @Inject
    lateinit var registerPresenter: RegisterPresenter
    @Inject
    lateinit var dialogProvider: DialogProvider

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, RegisterActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter.context = this
        registerPresenter.attachView(this)

        setUpComponents()
    }

    private fun setUpComponents() {
        register_button.setOnClickListener {
            registerPresenter.register(name_input.text.toString(),
                    lastname_input.text.toString(),
                    login_input.text.toString(),
                    password_input.text.toString(),
                    if (librarian_code_input.text.isEmpty().not()) librarian_code_input.text.toString() else null)
        }
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(login_background)
    }

    override fun successfulRegister() {
        onBackPressed()
    }

    override fun showProgress() {
        register_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        register_progress_bar.visibility = View.GONE
    }

    override fun showError(errorMsg: String) {

    }
}