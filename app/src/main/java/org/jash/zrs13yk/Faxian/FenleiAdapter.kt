package org.jash.zrs13yk.Faxian

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import org.jash.zrs13yk.Bean.FaxianData
import org.jash.zrs13yk.Bean.FenleiData
import org.jash.zrs13yk.R

class FenleiAdapter(list: ArrayList<FenleiData>):
    BaseQuickAdapter<FenleiData, BaseViewHolder>(R.layout.item_fenlei,list)  {
    override fun convert(helper: BaseViewHolder, item: FenleiData) {
        helper.setText(R.id.fnelei_tv,item.typename)
    }
}