package pslibrary.bookinformationactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class BookInformationPresenter(val booksApi: BooksApi,
                               val scheduler: ApplicationScheduler,
                               val dialogProvider: DialogProvider,
                               val userProvider: UserProvider) : BaseMvpPresenter<BookInformationView>() {

    var selectedBook: Book? = null
    var isFromMyBooks: Boolean = false
    lateinit var context: Context

    override fun attachView(view: BookInformationView?) {
        super.attachView(view)

        determineWhichControlsShouldBeShown()
    }

    private fun determineWhichControlsShouldBeShown() {
        if (isFromMyBooks) {
            view.showBorrowedBookOptions()
        } else {
            view.showToBeBorrowedBookOptions()
        }
    }

    fun rentBook() {

    }

    fun rentMoreBook() {

    }

    fun giveBackBook() {

    }


}