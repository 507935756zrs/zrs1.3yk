package org.jash.zrs13yk.Faxian

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jash.zrs13yk.Base.BaseRepo
import org.jash.zrs13yk.Bean.FaxianBean
import org.jash.zrs13yk.Bean.FenleiBean
import org.jash.zrs13yk.Bean.HomeBean

class FaxianRepo:BaseRepo() {
    fun faxian(page:Int,
             size:Int, success: MutableLiveData<FaxianBean>, filed: MutableLiveData<String>
    ){
        getApi().faxian(page, size)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<FaxianBean> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    filed.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: FaxianBean) {
                    success.value = t
                }
            })
    }
    fun fenlei(success: MutableLiveData<FenleiBean>, filed: MutableLiveData<String>
    ){
        getApi().fenlei()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<FenleiBean> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    filed.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: FenleiBean) {
                    success.value = t
                }
            })
    }
}