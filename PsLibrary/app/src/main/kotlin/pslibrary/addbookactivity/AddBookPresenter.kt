package pslibrary.addbookactivity

import android.content.Context
import com.ps.pslibrary.application.ApplicationScheduler
import com.ps.pslibrary.base.BaseMvpPresenter
import pslibrary.api.books.BooksApi
import pslibrary.api.books.model.AddBookBody
import pslibrary.customview.DialogProvider
import pslibrary.user.UserProvider

class AddBookPresenter(val booksApi: BooksApi,
                       val scheduler: ApplicationScheduler,
                       val dialogProvider: DialogProvider,
                       val userProvider: UserProvider) : BaseMvpPresenter<AddBookView>() {

    lateinit var context: Context

    override fun attachView(view: AddBookView?) {
        super.attachView(view)
    }

    fun addNewBook(title: String, genre: String, author: String, description: String) {
        scheduler.schedule(booksApi.addNewBook(AddBookBody(title, genre, author, description, userProvider.getUserToken())),
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

    private fun onAddBookSuccessDismiss() = {
        dialogProvider.dismissDialog()
        view.onBackActivity()
    }

    private fun onDismissDialog() = {
        dialogProvider.dismissDialog()
    }

}