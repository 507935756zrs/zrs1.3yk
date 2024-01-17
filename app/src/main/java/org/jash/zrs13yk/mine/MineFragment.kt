package org.jash.zrs13yk.mine

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import org.jash.zrs13yk.Base.BaseFrgment
import org.jash.zrs13yk.Bean.FaxianData
import org.jash.zrs13yk.Faxian.FaxianAdaoter
import org.jash.zrs13yk.R
import org.jash.zrs13yk.Xiangqing.XiangqingActivity
import org.jash.zrs13yk.databinding.FragmentMineBinding


class MineFragment : BaseFrgment<FragmentMineBinding>() {
    override fun getLout(): Int=R.layout.fragment_mine
    var viewModle = MineViewModel()
    var list = ArrayList<FaxianData>()
    lateinit var adapter: FaxianAdaoter
    override fun initView() {
        viewModle = ViewModelProvider(this)[MineViewModel::class.java]
        viewModle.mine("1")
        viewModle.success.observe(this){
            context?.let { it1 -> Glide.with(it1).load(it.data.avatar_url).into(binding.mineIv) }
            binding.mainName.text = it.data.name
            binding.mainName2.text = it.data.description
            binding.fensi.text = it.data.followerscount
        }
        viewModle.faxian1(1,4)
        viewModle.success1.observe(this){
            list.clear()
            list.addAll(it.data)
            adapter.notifyDataSetChanged()
        }
    }

    override fun initData() {
        binding.mainRv.layoutManager = GridLayoutManager(context,2)
        adapter = FaxianAdaoter(list)
        binding.mainRv.adapter = adapter

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