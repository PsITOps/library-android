package pslibrary.bookinformationactivity

interface BookInformationView {

    fun showBorrowedBookOptions()

    fun showToBeBorrowedBookOptions()

    fun showLibrarianBookOptions()

    fun setBackground()

    fun onBackActivity()

    fun displayBookData(title: String, author: String, genre: String, description: String)
}