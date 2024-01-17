package org.jash.zrs13yk.mine

import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.jash.zrs13yk.Base.BaseRepo
import org.jash.zrs13yk.Bean.FaxianBean
import org.jash.zrs13yk.Bean.HomeBean
import org.jash.zrs13yk.Bean.MainBean

class MineRepo:BaseRepo() {
    fun Mine(id:String, success: MutableLiveData<MainBean>, filed: MutableLiveData<String>
    ){
        getApi().main(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<MainBean> {
                override fun onSubscribe(d: Disposable) {

                }

                override fun onError(e: Throwable) {
                    filed.value = e.message
                }

                override fun onComplete() {

                }

                override fun onNext(t: MainBean) {
                    success.value = t
                }
            })
    }
    fun faxian1(page:Int,
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
}