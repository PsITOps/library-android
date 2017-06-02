package pslibrary.addbookactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_add_book.*
import kotlinx.android.synthetic.main.activity_books.*
import javax.inject.Inject

class AddBookActivity : AppCompatActivity(), AddBookView {

    @Inject
    lateinit var presenter: AddBookPresenter

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, AddBookActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        initializeComponents()
    }

    private fun initializeComponents() {
        presenter.context = this
        presenter.attachView(this)

        add_book_button.setOnClickListener {
            presenter.addNewBook(title_input.text.toString(),
                    genre_input.text.toString(),
                    author_input.text.toString(),
                    description_input.text.toString())
        }
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(add_book_background)
    }

    override fun onBackActivity() {
        onBackPressed()
    }
}