package org.jash.zrs13yk.Login

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jash.zrs13yk.Base.BaseRepo
import org.jash.zrs13yk.Bean.UserBean
import org.jash.zrs13yk.Bean.UserData

class LoginRepo :BaseRepo(){
    fun Login(password:String,
              username:String,success:MutableLiveData<UserBean>,filed:MutableLiveData<String>){
        getApi().login(password, username)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object :Observer<UserBean>{
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    filed.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: UserBean) {
                   success.value = t
                }
            })
    }
}