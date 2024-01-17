package org.jash.zrs13yk.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import org.jash.zrs13yk.Base.BaseActivity
import org.jash.zrs13yk.MainActivity
import org.jash.zrs13yk.R
import org.jash.zrs13yk.databinding.ActivityLoginBinding

class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    var viewModle = LoginViewModle()
    override fun initView() {
        viewModle = ViewModelProvider(this)[LoginViewModle::class.java]
        viewModle.success.observe(this){
            ToastUtils.showLong(it.msg)
            if (it.code==0){
                SPUtils.getInstance().put("sp_token",it.data.token)
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun initData() {
        binding.loginBt.setOnClickListener {
            viewModle.login(
                binding.loginName.text.toString(),
                binding.loginParss.text.toString()
            )
        }
    }

    override fun getLout(): Int {
        return R.layout.activity_login
    }

}