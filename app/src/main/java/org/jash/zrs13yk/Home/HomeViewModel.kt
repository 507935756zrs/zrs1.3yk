package org.jash.zrs13yk.Home

import androidx.lifecycle.MutableLiveData
import org.jash.zrs13yk.Base.BaseViewModel
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Bean.UserBean
import org.jash.zrs13yk.Login.LoginRepo

class HomeViewModel:BaseViewModel() {
    var success= MutableLiveData<HomeBean>()
    var filed= MutableLiveData<String>()
    val repo = HomeRepo()
    fun home(page:Int,
              size:Int,){
        repo.home(page, size, success, filed)
    }
}