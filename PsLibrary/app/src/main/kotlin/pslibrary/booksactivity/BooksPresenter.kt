package pslibrary.booksactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import com.ps.pslibrary.navigator.Navigator
import pslibrary.api.books.BooksApi
import pslibrary.api.books.converter.BookConverter
import pslibrary.api.books.model.Book
import pslibrary.booksactivity.adapter.BookViewType
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class BooksPresenter(val booksApi: BooksApi,
                     val navigator: Navigator,
                     val scheduler: ApplicationScheduler,
                     val dialogProvider: DialogProvider,
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
                    if (it.valid) {
                        booksView.showBookList(BookConverter.convertBookWithoutNullParams(it.bookList).map { mapBookToBookViewType(it) })
                    } else {
                        dialogProvider.showErrorDialog(context, it.message)
                    }
                },
                { booksView.hideProgress() },
                this)
    }

    private fun mapBookToBookViewType(book: Book): BookViewType {
        val bookViewType = BookViewType(book, true, false)

        bookViewType.onBookSelection = {
            navigator.openBookInformationActivity(context, it, false)
        }

        return bookViewType
    }

    fun openMyBooksActivity() {
        navigator.openMyBooksActivity(context)
    }

    fun openAddBookActivity() {
        navigator.openAddBookActivity(context, null)
    }

    fun isLibrarian() = userProvider.isLibrarian()
}