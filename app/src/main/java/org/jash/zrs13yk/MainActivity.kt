package org.jash.zrs13yk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.jash.zrs13yk.Base.BaseActivity
import org.jash.zrs13yk.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun initView() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.mainBv.setupWithNavController(navController)
    }

    override fun initData() {

    }

    override fun getLout(): Int =R.layout.activity_main

}