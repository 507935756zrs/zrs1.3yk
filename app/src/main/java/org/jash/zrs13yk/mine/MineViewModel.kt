package org.jash.zrs13yk.mine

import androidx.lifecycle.MutableLiveData
import org.jash.zrs13yk.Base.BaseViewModel
import org.jash.zrs13yk.Bean.FaxianBean
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Bean.MainBean
import org.jash.zrs13yk.Home.HomeRepo

class MineViewModel:BaseViewModel() {
    var success= MutableLiveData<MainBean>()
    var filed= MutableLiveData<String>()
    val repo = MineRepo()
    var success1= MutableLiveData<FaxianBean>()
    var filed1= MutableLiveData<String>()
    fun mine(id:String){
        repo.Mine(id, success, filed)
    }
    fun faxian1(page:Int,
               size:Int,){
        repo.faxian1(page, size, success1, filed1)
    }
}