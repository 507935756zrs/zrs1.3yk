package org.jash.zrs13yk.Xiangqing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import org.jash.zrs13yk.Base.BaseActivity
import org.jash.zrs13yk.R
import org.jash.zrs13yk.databinding.ActivityXiangqingBinding

class XiangqingActivity : BaseActivity<ActivityXiangqingBinding>() {
    override fun initView() {
        val ming = intent.getStringExtra("ming")
        val zi = intent.getStringExtra("zi")
        val tou = intent.getStringExtra("tou")
        val vid = intent.getStringExtra("vid")
        if (vid!=null){
            binding.xiangqinagWv.loadUrl(vid)
            binding.mingzi.text = ming
            Glide.with(this).load(tou).into(binding.touxiang)
            binding.zimu.text = zi
        }
    }

    override fun initData() {

    }

    override fun getLout(): Int =R.layout.activity_xiangqing

}