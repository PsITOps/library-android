package pslibrary.addbookactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.Book
import pslibrary.api.books.model.bookBody
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class AddBookPresenter(val booksApi: BooksApi,
                       val scheduler: ApplicationScheduler,
                       val dialogProvider: DialogProvider,
                       val userProvider: UserProvider) : BaseMvpPresenter<AddBookView>() {

    lateinit var context: Context

    var selectedBook: Book? = null

    override fun attachView(view: AddBookView?) {
        super.attachView(view)
        this.view.setBackground()

        if (selectedBook != null && selectedBook!!.title!!.isNotEmpty()) {
            this.view.setEditBookComponents(selectedBook!!.title!!, selectedBook!!.genre!!, selectedBook!!.author!!, selectedBook!!.description!!)
        }
    }

    fun addNewBook(title: String, genre: String, author: String, description: String) {
        scheduler.schedule(booksApi.addNewBook(bookBody(title, genre, author, description, userProvider.getUserToken())),
                {
                    if (it.valid) {
                        dialogProvider.showSuccessDialog(context, "Udało się dodać nową książkę", onAddBookSuccessDismiss(), onAddBookSuccessDismiss())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onDismissDialog(), onDismissDialog())
                    }
                },
                { dialogProvider.showErrorDialog(context, "Nie udało się dodać nowej książki", onDismissDialog(), onDismissDialog()) },
                this)
    }

    fun editBook(title: String, genre: String, author: String, description: String) {
        scheduler.schedule(booksApi.editBook(selectedBook!!.id, bookBody(title, genre, author, description, userProvider.getUserToken())),
                {
                    if (it.valid) {
                        dialogProvider.showSuccessDialog(context, "Udało się edytować książkę", onAddBookSuccessDismiss(), onAddBookSuccessDismiss())
                    } else {
                        dialogProvider.showErrorDialog(context, it.message, onDismissDialog(), onDismissDialog())
                    }
                },
                { dialogProvider.showErrorDialog(context, "Nie udało się edytować książki", onDismissDialog(), onDismissDialog()) },
                this)
    }

    private fun onAddBookSuccessDismiss() = {
        dialogProvider.dismissDialog()
        view.onBackActivity()
    }

    private fun onDismissDialog() = {
        dialogProvider.dismissDialog()
    }

}