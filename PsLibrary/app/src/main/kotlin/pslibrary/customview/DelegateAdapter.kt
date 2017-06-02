package pslibrary.customview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import pslibrary.customview.adapter.AdapterContentType
import pslibrary.customview.adapter.ViewType
import pslibrary.customview.adapter.ViewTypeDelegateAdapter

abstract class DelegateAdapter(val context: Context) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    protected abstract var delegateAdapters: Map<AdapterContentType, ViewTypeDelegateAdapter>
    open var items: List<ViewType> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int) = items[position].getViewType()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, position, null)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int, payloads: MutableList<Any>?) {
        delegateAdapters[adapterContentType(position)]!!
                .onBindViewHolder(holder, items[position], payloads)
    }

    private fun adapterContentType(position: Int) = AdapterContentType.values()[getItemViewType(position)]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val contentType = AdapterContentType.values()[viewType]
        val delegateAdapter = delegateAdapters[contentType]
        return delegateAdapter?.onCreateViewHolder(parent)
                ?: throw IllegalStateException("Missing mapping for $contentType view type")
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder?) {
        super.onViewDetachedFromWindow(holder)
    }

    override fun getItemCount() = items.size
}