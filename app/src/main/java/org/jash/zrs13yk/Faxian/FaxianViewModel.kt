package org.jash.zrs13yk.Faxian

import androidx.lifecycle.MutableLiveData
import org.jash.zrs13yk.Base.BaseViewModel
import org.jash.zrs13yk.Bean.FaxianBean
import org.jash.zrs13yk.Bean.FenleiBean
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Home.HomeRepo

class FaxianViewModel:BaseViewModel() {
    var success= MutableLiveData<FaxianBean>()
    var filed= MutableLiveData<String>()
    var success1= MutableLiveData<FenleiBean>()
    var filed1= MutableLiveData<String>()
    val repo = FaxianRepo()
    fun faxian(page:Int,
             size:Int,){
        repo.faxian(page, size, success, filed)
    }
    fun fenlei(){
        repo.fenlei(success1, filed1)
    }
}