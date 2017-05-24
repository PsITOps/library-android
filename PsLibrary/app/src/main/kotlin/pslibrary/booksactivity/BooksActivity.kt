package pslibrary.booksactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_books.*
import javax.inject.Inject

class BooksActivity : AppCompatActivity(), BooksView {

    @Inject
    lateinit var booksPresenter: BooksPresenter

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, BooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        booksPresenter.context = this
        booksPresenter.attachView(this)
        booksPresenter.showBooksList()
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_login_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(books_background)
    }

    override fun showProgress() {
        books_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        books_progress_bar.visibility = View.GONE
    }
}