package org.jash.zrs13yk.Home

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import org.jash.zrs13yk.Bean.HomeData
import org.jash.zrs13yk.R

class HomeAdapter(list: ArrayList<HomeData>):BaseQuickAdapter<HomeData,BaseViewHolder>(R.layout.item_home,list) {
    override fun convert(helper: BaseViewHolder, item: HomeData) {
        Glide.with(context).load(item.videomainimag).into(helper.getView(R.id.home_item_im))
    }
}