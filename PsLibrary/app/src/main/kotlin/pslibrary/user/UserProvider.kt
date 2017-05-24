package pslibrary.user

interface UserProvider {

    fun setUserToken(token: String)

    fun setLibrarian(isLibrarian: Boolean)

    fun getUserToken() : String

    fun isLibrarian() : Boolean
}