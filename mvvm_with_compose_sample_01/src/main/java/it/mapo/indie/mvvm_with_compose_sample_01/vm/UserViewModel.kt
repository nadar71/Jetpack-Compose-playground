import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel

class UserViewModel : ViewModel() {

    private val _users = mutableStateListOf<User>()

    val users: List<User>
        get() = _users

    fun addUser(user: User) {
        _users.add(user)
    }
}