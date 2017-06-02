package pslibrary.booksactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.booksactivity.adapter.BookViewType
import pslibrary.user.UserProvider

class BooksPresenter(val booksApi: BooksApi,
                     val scheduler: ApplicationScheduler,
                     val userProvider: UserProvider) : BaseMvpPresenter<BooksView>() {

    lateinit var booksView: BooksView
    lateinit var context: Context

    override fun attachView(view: BooksView) {
        super.attachView(view)
        booksView = view

        booksView.setBackground()
    }

    fun showBooksList() {
        booksView.showProgress()
        scheduler.schedule(booksApi.getBooks(userProvider.getUserToken()),
                {
                    booksView.hideProgress()
                    booksView.showBookList(it.bookList.map { mapBookToBookViewType(it) })
                },
                { booksView.hideProgress() },
                this)
    }

    private fun mapBookToBookViewType(book: Book): BookViewType {
        val bookViewType = BookViewType(book, true)

        bookViewType.onBookSelection = {

        }

        return bookViewType
    }
}