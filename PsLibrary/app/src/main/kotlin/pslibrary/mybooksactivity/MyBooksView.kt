package pslibrary.mybooksactivity

import pslibrary.customview.adapter.ViewType

interface MyBooksView {

    fun showProgress()

    fun hideProgress()

    fun setBackground()

    fun showBookList(items: List<ViewType>)
}