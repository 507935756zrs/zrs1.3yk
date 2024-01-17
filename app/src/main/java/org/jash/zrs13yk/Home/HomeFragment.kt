package org.jash.zrs13yk.Home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import org.jash.zrs13yk.Base.BaseFrgment
import org.jash.zrs13yk.Bean.HomeData
import org.jash.zrs13yk.Login.LoginViewModle
import org.jash.zrs13yk.MainActivity
import org.jash.zrs13yk.R
import org.jash.zrs13yk.Xiangqing.XiangqingActivity
import org.jash.zrs13yk.databinding.FragmentHomeBinding


class HomeFragment : BaseFrgment<FragmentHomeBinding>() {
    override fun getLout(): Int =R.layout.fragment_home
    var viewModle = HomeViewModel()
    var list = ArrayList<HomeData>()
    lateinit var adapter: HomeAdapter
    override fun initView() {
        viewModle = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModle.home(1,10)
        viewModle.success.observe(this){
            list.clear()
            list.addAll(it.data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun initData() {
        binding.homeRv.layoutManager = GridLayoutManager(context,1)
        adapter = HomeAdapter(list)
        binding.homeRv.adapter = adapter

        adapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(context, XiangqingActivity::class.java)
            intent.putExtra("ming",list[position].name)
            intent.putExtra("zi",list[position].title)
            intent.putExtra("tou",list[position].avatar_url)
            intent.putExtra("vid",list[position].videopath)
            startActivity(intent)
        }
    }

}