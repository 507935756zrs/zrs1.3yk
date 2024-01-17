package org.jash.zrs13yk.Faxian

import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import org.jash.zrs13yk.Bean.FaxianData
import org.jash.zrs13yk.Bean.HomeData
import org.jash.zrs13yk.R

class FaxianAdaoter(list: ArrayList<FaxianData>):
    BaseQuickAdapter<FaxianData, BaseViewHolder>(R.layout.item_faxian,list) {
    override fun convert(helper: BaseViewHolder, item: FaxianData) {
        Glide.with(context).load(item.videomainimag).into(helper.getView(R.id.faxian_iv))
    }
}