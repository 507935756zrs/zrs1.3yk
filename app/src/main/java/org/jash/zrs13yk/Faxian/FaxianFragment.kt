package org.jash.zrs13yk.Faxian

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.jash.zrs13yk.Base.BaseFrgment
import org.jash.zrs13yk.Bean.FaxianData
import org.jash.zrs13yk.Bean.FenleiData
import org.jash.zrs13yk.Bean.HomeData
import org.jash.zrs13yk.Home.HomeAdapter
import org.jash.zrs13yk.Home.HomeViewModel
import org.jash.zrs13yk.R
import org.jash.zrs13yk.Xiangqing.XiangqingActivity
import org.jash.zrs13yk.databinding.FragmentFaxianBinding
import org.jash.zrs13yk.databinding.FragmentHomeBinding

class FaxianFragment : BaseFrgment<FragmentFaxianBinding>() {
    override fun getLout(): Int =R.layout.fragment_faxian
    var viewModle = FaxianViewModel()
    var list = ArrayList<FaxianData>()
    lateinit var adapter: FaxianAdaoter
    var list2 = ArrayList<FenleiData>()
    lateinit var adapter2: FenleiAdapter
    var page = 1
    override fun initView() {
        viewModle = ViewModelProvider(this)[FaxianViewModel::class.java]
        viewModle.faxian(page,10)
        viewModle.success.observe(this){
            list.clear()
            list.addAll(it.data)
            adapter.notifyDataSetChanged()
        }
        viewModle.fenlei()
        viewModle.success1.observe(this){
            list2.clear()
            list2.addAll(it.data)
            adapter2.notifyDataSetChanged()
        }
    }

    override fun initData() {
        binding.faxianRv.layoutManager = GridLayoutManager(context,2)
        adapter = FaxianAdaoter(list)
        binding.faxianRv.adapter = adapter

        binding.fenleiRv.layoutManager = LinearLayoutManager(context,RecyclerView.HORIZONTAL,false)
        adapter2 = FenleiAdapter(list2)
        binding.fenleiRv.adapter = adapter2

        adapter.setOnItemClickListener { adapter, view, position ->
            val intent = Intent(context, XiangqingActivity::class.java)
            intent.putExtra("ming",list[position].name)
            intent.putExtra("zi",list[position].title)
            intent.putExtra("tou",list[position].avatar_url)
            intent.putExtra("vid",list[position].videopath)
            startActivity(intent)
        }

        adapter2.setOnItemClickListener { adapter, view, position ->
            page = list2[position].id
            viewModle.faxian(page,10)
        }
    }

}