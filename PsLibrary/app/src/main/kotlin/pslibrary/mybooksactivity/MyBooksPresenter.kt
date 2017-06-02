package pslibrary.mybooksactivity

import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.booksactivity.adapter.BookViewType
import pslibrary.user.UserProvider

class MyBooksPresenter(val booksApi: BooksApi,
                       val scheduler: ApplicationScheduler,
                       val userProvider: UserProvider) : BaseMvpPresenter<MyBooksView>() {

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
                    view.showBookList(it.bookList.map { mapBookToBookViewType(it) })
                },
                { view.hideProgress() },
                this)
    }

    private fun mapBookToBookViewType(book: Book): BookViewType {
        val bookViewType = BookViewType(book, false)

        bookViewType.onBookSelection = {

        }

        return bookViewType
    }
}