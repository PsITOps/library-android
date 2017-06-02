package pslibrary.mybooksactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import com.ps.pslibrary.navigator.Navigator
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.booksactivity.adapter.BookViewType
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class MyBooksPresenter(val booksApi: BooksApi,
                       val navigator: Navigator,
                       val scheduler: ApplicationScheduler,
                       val dialogProvider: DialogProvider,
                       val userProvider: UserProvider) : BaseMvpPresenter<MyBooksView>() {

    lateinit var context: Context

    override fun attachView(view: MyBooksView?) {
        super.attachView(view)
        this.view.setBackground()
        downloadMyBooks()
    }

    fun downloadMyBooks() {
        view.showProgress()
        scheduler.schedule(booksApi.getMyBooks(userProvider.getUserToken()),
                {
                    view.hideProgress()
                    if (it.valid) {
                        view.showBookList(it.bookList.map { mapBookToBookViewType(it) })
                    } else {
                        dialogProvider.showErrorDialog(context, it.message)
                    }
                },
                { view.hideProgress() },
                this)
    }

    private fun mapBookToBookViewType(book: Book): BookViewType {
        val bookViewType = BookViewType(book, false, true)

        bookViewType.onBookSelection = {
            navigator.openBookInformationActivity(context, it, true)
        }

        return bookViewType
    }
}