package pslibrary.booksactivity.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.ps.pslibrary.R
import kotlinx.android.synthetic.main.row_book.view.*
import pslibrary.customview.adapter.ViewType
import pslibrary.customview.adapter.ViewTypeDelegateAdapter

class BookDelegateAdapter(override val context: Context) :
        ViewTypeDelegateAdapter {

    internal inner class BookViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        var bookTitle: TextView? = null
        var bookGenre: TextView? = null
        var bookDescription: TextView? = null
        var bookAuthor: TextView? = null
        var bookAvailabilityIcon: ImageView? = null

        fun populate(bookViewType: BookViewType) {
            bookTitle = view.book_title
            bookGenre = view.book_genre
            bookDescription = view.book_description
            bookAuthor = view.book_author
            bookAvailabilityIcon = view.book_availability_icon

            bookTitle?.text = bookViewType.book.title
            bookGenre?.text = bookViewType.book.genre

            if (bookViewType.book.description == null) {
                bookDescription?.visibility = View.GONE
            } else {
                bookDescription?.visibility = View.VISIBLE
                bookDescription?.text = bookViewType.book.description
            }
            bookAuthor?.text = bookViewType.book.author

            view.setOnClickListener {
                if (bookViewType.isFromMyBooks.not() && bookViewType.book.isAvailable.not()) {

                } else {
                    bookViewType.onBookSelection.invoke(bookViewType.book)
                }
            }

            controlBookAvailabilityIcon(bookViewType)

        }

        private fun controlBookAvailabilityIcon(bookViewType: BookViewType) {
            if (bookViewType.book.isAvailable) {
                bookAvailabilityIcon?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_book_available))
            } else {
                bookAvailabilityIcon?.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_book_not_available))
            }

            if (bookViewType.isAvailabilityIconVisible) {
                bookAvailabilityIcon?.visibility = View.VISIBLE
            } else {
                bookAvailabilityIcon?.visibility = View.GONE
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType, payloads: MutableList<Any>?) {
        holder as BookViewHolder
        holder.populate(item as BookViewType)
    }

}