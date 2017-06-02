package pslibrary.bookinformationactivity

interface BookInformationView {

    fun showBorrowedBookOptions()

    fun showToBeBorrowedBookOptions()

    fun setBackground()

    fun onBackActivity()

    fun displayBookData(title: String, author: String, genre: String, description: String)
}