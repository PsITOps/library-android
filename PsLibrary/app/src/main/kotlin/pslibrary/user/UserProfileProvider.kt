package pslibrary.user

class UserProfileProvider : UserProvider {

    private var userToken: String = ""
    private var librarian: Boolean = false

    override fun setUserToken(token: String) {
        userToken = token
    }

    override fun setLibrarian(isLibrarian: Boolean) {
        librarian = isLibrarian
    }

    override fun getUserToken() = userToken

    override fun isLibrarian() = librarian
}