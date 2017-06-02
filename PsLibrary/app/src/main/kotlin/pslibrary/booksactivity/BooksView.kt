package pslibrary.booksactivity

import pslibrary.customview.adapter.ViewType

interface BooksView {

    fun showProgress()

    fun hideProgress()

    fun setBackground()

    fun showBookList(items: List<ViewType>)
}