package pslibrary.bookinformationactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import kotlinx.android.synthetic.main.activity_book_information.*
import pslibrary.api.books.model.Book
import pslibrary.mybooksactivity.MyBooksActivity
import javax.inject.Inject

class BookInformationActivity : AppCompatActivity(), BookInformationView {

    @Inject
    lateinit var presenter: BookInformationPresenter

    companion object Factory {
        const val BOOK = "book"
        const val FROM_MY_BOOKS = "my_books"
        @JvmStatic fun createIntent(context: Context, book: Book, isFromMyBooks: Boolean) = Intent(context, MyBooksActivity::class.java).apply {
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

    private fun initComponents() {
        presenter.context = this

        getParamsFromIntent()

        presenter.attachView(this)
    }

    private fun getParamsFromIntent() {
        presenter.selectedBook = intent.extras.getParcelable(BOOK)
        presenter.isFromMyBooks = intent.extras.getBoolean(FROM_MY_BOOKS)
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
}