package org.jash.zrs13yk.Home

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jash.zrs13yk.Base.BaseRepo
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Bean.HomeData
import org.jash.zrs13yk.Bean.UserBean

class HomeRepo:BaseRepo() {
    fun home(page:Int,
             size:Int, success: MutableLiveData<HomeBean>, filed: MutableLiveData<String>
    ){
        getApi().home(page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<HomeBean> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    filed.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: HomeBean) {
                    success.value = t
                }
            })
    }
}