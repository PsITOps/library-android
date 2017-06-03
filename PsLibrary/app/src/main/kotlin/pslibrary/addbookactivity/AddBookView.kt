package pslibrary.addbookactivity

interface AddBookView {

    fun setBackground()

    fun onBackActivity()

    fun setEditBookComponents(title: String, genre: String, author: String, description: String)

}