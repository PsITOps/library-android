package pslibrary.booksactivity

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


class BooksActivity : AppCompatActivity(), BooksView {

    @Inject
    lateinit var booksPresenter: BooksPresenter

    private lateinit var bookAdapter: BooksActivityAdapter

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, BooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        initializeComponents()
    }

    override fun onResume() {
        super.onResume()
        initializeComponents()
    }

    override fun onDestroy() {
        booksPresenter.detachView()
        super.onDestroy()
    }

    private fun initializeComponents() {
        booksPresenter.context = this
        booksPresenter.attachView(this)
        booksPresenter.showBooksList()

        bookAdapter = BooksActivityAdapter(this)
        book_list.adapter = bookAdapter
        val layoutManager = LinearLayoutManager(this)
        book_list.layoutManager = layoutManager

        if (booksPresenter.isLibrarian()) {
            my_books_button.visibility = View.GONE
            add_book_button.visibility = View.VISIBLE
            add_book_button.setOnClickListener {
                booksPresenter.openAddBookActivity()
            }
        } else {
            my_books_button.setOnClickListener {
                booksPresenter.openMyBooksActivity()
            }
        }
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(books_background)
    }

    override fun showProgress() {
        books_progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        books_progress_bar.visibility = View.GONE
    }

    override fun showBookList(items: List<ViewType>) {
        book_list.visibility = View.VISIBLE

        bookAdapter.items = items
    }
}