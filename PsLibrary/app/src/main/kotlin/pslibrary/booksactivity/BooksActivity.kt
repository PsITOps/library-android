package pslibrary.booksactivity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.ps.pslibrary.R
import com.ps.pslibrary.application.LibraryApplication

class BooksActivity : AppCompatActivity(), BooksView {

    companion object Factory {
        @JvmStatic fun createIntent(context: Context) = Intent(context, BooksActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as LibraryApplication).uiDependencies.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)
    }
}