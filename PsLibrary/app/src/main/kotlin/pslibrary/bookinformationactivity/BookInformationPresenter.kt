package pslibrary.bookinformationactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.api.books.model.TokenBody
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

        this.view.setBackground()

        determineWhichControlsShouldBeShown()
        this.view.displayBookData(selectedBook!!.title ?: "", selectedBook!!.author ?: "", selectedBook!!.genre ?: "", selectedBook!!.description ?: "")
    }

    private fun determineWhichControlsShouldBeShown() {
        if (isFromMyBooks) {
            view.showBorrowedBookOptions()
        } else {
            view.showToBeBorrowedBookOptions()
        }
    }

    fun rentBook() {
        scheduler.schedule(booksApi.rentBook(selectedBook!!.id, TokenBody(userProvider.getUserToken())),
                {
                    if (it.valid) {
                        dialogProvider.showSuccessDialog(context, "Udało się zarezerwować książkę", onRentBookSuccessDismiss(), onRentBookSuccessDismiss())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onDismissDialog(), onDismissDialog())
                    }
                },
                { dialogProvider.showErrorDialog(context, "Nie udało się zarezerwować książki", onDismissDialog(), onDismissDialog()) },
                this)
    }

    fun rentMoreBook() {
        scheduler.schedule(booksApi.rentMoreBook(selectedBook!!.id, TokenBody(userProvider.getUserToken())),
                {
                    if (it.valid) {
                        dialogProvider.showSuccessDialog(context, "Udało się przedłużyć rezerwację", onRentBookSuccessDismiss(), onRentBookSuccessDismiss())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onDismissDialog(), onDismissDialog())
                    }
                },
                { dialogProvider.showErrorDialog(context, "Nie udało się przedłużyć rezerwacji", onDismissDialog(), onDismissDialog()) },
                this)
    }

    fun giveBackBook() {
        scheduler.schedule(booksApi.returnBook(selectedBook!!.id, TokenBody(userProvider.getUserToken())),
                {
                    if (it.valid) {
                        dialogProvider.showSuccessDialog(context, "Udało się oddać książkę", onRentBookSuccessDismiss(), onRentBookSuccessDismiss())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onDismissDialog(), onDismissDialog())
                    }
                },
                { dialogProvider.showErrorDialog(context, "Nie udało się oddać książki", onDismissDialog(), onDismissDialog()) },
                this)
    }

    private fun onRentBookSuccessDismiss() = {
        dialogProvider.dismissDialog()
        view.onBackActivity()
    }

    private fun onDismissDialog() = {
        dialogProvider.dismissDialog()
    }

}