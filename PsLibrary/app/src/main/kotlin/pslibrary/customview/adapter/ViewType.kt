package pslibrary.customview.adapter

interface ViewType {

    companion object {
        val DEFAULT_ADAPTER_ID = "default_adapter_ID"
    }

    fun getAdapterId(): String = DEFAULT_ADAPTER_ID

    fun getViewType(): Int
}