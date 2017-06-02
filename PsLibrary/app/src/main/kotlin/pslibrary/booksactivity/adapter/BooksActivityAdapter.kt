package pslibrary.booksactivity.adapter

import android.content.Context
import pslibrary.customview.DelegateAdapter
import pslibrary.customview.adapter.AdapterContentType
import pslibrary.customview.adapter.ViewTypeDelegateAdapter

open class BooksActivityAdapter(context: Context) : DelegateAdapter(context) {

    override var delegateAdapters: Map<AdapterContentType, ViewTypeDelegateAdapter> = mapOf(
            AdapterContentType.BOOKS to BookDelegateAdapter(context))

}