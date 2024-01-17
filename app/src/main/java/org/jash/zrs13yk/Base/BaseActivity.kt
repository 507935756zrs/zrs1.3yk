package org.jash.zrs13yk.Base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<VDB:ViewDataBinding>:AppCompatActivity() {
    lateinit var binding: VDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,getLout())
        initData()
        initView()
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun getLout(): Int


}