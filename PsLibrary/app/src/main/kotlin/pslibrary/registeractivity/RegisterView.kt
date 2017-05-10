package pslibrary.registeractivity

interface RegisterView {

    fun successfulRegister()

    fun setBackground()

    fun showProgress()

    fun hideProgress()

    fun showError(errorMsg: String)
}