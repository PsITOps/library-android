package pslibrary.bookinformationactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_book_information.*
import pslibrary.api.books.model.Book
import javax.inject.Inject

class BookInformationActivity : AppCompatActivity(), BookInformationView {

    @Inject
    lateinit var presenter: BookInformationPresenter

    companion object Factory {
        const val BOOK = "book"
        const val FROM_MY_BOOKS = "my_books"
        @JvmStatic fun createIntent(context: Context, book: Book, isFromMyBooks: Boolean) = Intent(context, BookInformationActivity::class.java).apply {
            putExtra(BOOK, book)
            putExtra(FROM_MY_BOOKS, isFromMyBooks)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_information)

        initComponents()
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    private fun initComponents() {
        presenter.context = this

        getParamsFromIntent()

        presenter.attachView(this)
    }

    private fun getParamsFromIntent() {
        presenter.selectedBook = intent.extras.getParcelable(BOOK)
        presenter.isFromMyBooks = intent.extras.getBoolean(FROM_MY_BOOKS)
    }

    override fun displayBookData(title: String, author: String, genre: String, description: String) {
        book_title.text = title
        book_author.text = author
        book_genre.text = genre
        book_description.text = description
    }

    override fun showBorrowedBookOptions() {
        borrowed_book_components.visibility = View.VISIBLE
        give_back_book.setOnClickListener { presenter.giveBackBook() }
        rent_more_book.setOnClickListener { presenter.rentMoreBook() }
    }

    override fun showToBeBorrowedBookOptions() {
        not_borrowed_book_components.visibility = View.VISIBLE
        rent_book.setOnClickListener { presenter.rentBook() }
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(background)
    }

    override fun onBackActivity() {
        onBackPressed()
    }
}