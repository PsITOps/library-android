package pslibrary.addbookactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication
import jp.wasabeef.glide.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_add_book.*
import pslibrary.api.books.model.Book
import pslibrary.bookinformationactivity.BookInformationActivity
import javax.inject.Inject

class AddBookActivity : AppCompatActivity(), AddBookView {

    @Inject
    lateinit var presenter: AddBookPresenter

    companion object Factory {
        const val BOOK = "book"
        @JvmStatic fun createIntent(context: Context, book: Book) = Intent(context, AddBookActivity::class.java).apply {
            putExtra(BookInformationActivity.BOOK, book)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)

        checkForBook()
        initializeComponents()
    }

    private fun checkForBook() {
        presenter.selectedBook = intent.extras.getParcelable(BOOK)
    }

    private fun initializeComponents() {
        add_book_button.setOnClickListener {
            presenter.addNewBook(title_input.text.toString(),
                    genre_input.text.toString(),
                    author_input.text.toString(),
                    description_input.text.toString())
        }

        presenter.context = this
        presenter.attachView(this)
    }

    override fun setBackground() {
        Glide.with(this).load(R.drawable.library_background)
                .bitmapTransform(BlurTransformation(this, 20))
                .into(add_book_background)
    }

    override fun setEditBookComponents(title: String, genre: String, author: String, description: String) {
        title_input.setText(title)
        genre_input.setText(genre)
        author_input.setText(author)
        description_input.setText(description)


        add_book_button.text = "Edytuj książkę"
        add_book_button.setOnClickListener {
            presenter.editBook(title_input.text.toString(),
                    genre_input.text.toString(),
                    author_input.text.toString(),
                    description_input.text.toString())
        }
    }

    override fun onBackActivity() {
        onBackPressed()
    }
}