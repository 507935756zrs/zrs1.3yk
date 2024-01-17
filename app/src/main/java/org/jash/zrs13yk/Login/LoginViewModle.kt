package org.jash.zrs13yk.Login

import androidx.lifecycle.MutableLiveData
import org.jash.zrs13yk.Base.BaseViewModel
import org.jash.zrs13yk.Bean.UserBean

class LoginViewModle:BaseViewModel() {
    var success=MutableLiveData<UserBean>()
    var filed=MutableLiveData<String>()
    val repo = LoginRepo()
    fun login(username:String, password:String){
        repo.Login(password, username, success, filed)
    }
}