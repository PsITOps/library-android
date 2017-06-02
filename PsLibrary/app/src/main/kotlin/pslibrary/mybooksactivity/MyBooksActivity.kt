package pslibrary.mybooksactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_books.*
import pslibrary.booksactivity.adapter.BooksActivityAdapter
import pslibrary.customview.adapter.ViewType
import javax.inject.Inject

class MyBooksActivity : AppCompatActivity(), MyBooksView {

    @Inject
    lateinit var presenter: MyBooksPresenter

    private lateinit var bookAdapter: BooksActivityAdapter

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, MyBooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        initializeComponents()
    }

    private fun initializeComponents() {
        presenter.attachView(this)

        bookAdapter = BooksActivityAdapter(this)
        book_list.adapter = bookAdapter
        val layoutManager = LinearLayoutManager(this)
        book_list.layoutManager = layoutManager

        my_books_button.visibility = View.GONE
    }

    override fun showProgress() {
        books_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        books_progress_bar.visibility = View.GONE
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_login_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(books_background)
    }

    override fun showBookList(items: List<ViewType>) {
    }
}