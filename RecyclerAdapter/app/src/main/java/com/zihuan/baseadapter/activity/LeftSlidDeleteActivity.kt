package com.zihuan.baseadapter.activity

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.zihuan.baseadapter.Demo3Adapter
import com.zihuan.baseadapter.R
import com.zihuan.baseadapter.listener.ViewOnItemClick
import com.zihuan.baseadapter.slideswaphelper.PlusItemSlideCallback
import com.zihuan.baseadapter.slideswaphelper.WItemTouchHelperPlus
import kotlinx.android.synthetic.main.activity_left_slid_layout.*


class LeftSlidDeleteActivity : Activity(), ViewOnItemClick {
    override fun setOnItemClickListener(view: View?, postion: Int) {
        Toast.makeText(this, "点击$postion", Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left_slid_layout)
        var demoAdapter = Demo3Adapter(this)
        var mDemoData = ArrayList<String>()
        for (i in 0..30) {
            mDemoData.add("昵称$i")
        }

        rv_left_slid.buildVerticalLayout(demoAdapter)
                .setData(mDemoData)
        //侧滑布局被覆盖
//        val callback = PlusItemSlideCallback()
//        val extension = WItemTouchHelperPlus(callback)
//        extension.attachToRecyclerView(recyclerView)
        //侧滑布局跟随
        var callback = PlusItemSlideCallback()
        callback.setType(WItemTouchHelperPlus.SLIDE_ITEM_TYPE_ITEMVIEW)
        var extension = WItemTouchHelperPlus(callback)
        extension.attachToRecyclerView(rv_left_slid.getRecyclerView())
    }


}