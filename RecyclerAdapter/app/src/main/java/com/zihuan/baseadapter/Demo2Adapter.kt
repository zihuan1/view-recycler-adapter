package com.zihuan.baseadapter

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.zihuan.autoscrollview.ZHAutoScrollView
import com.zihuan.view.crvlibrary.ZRecyclerData

class Demo2Adapter(`object`: Any?) : RecyclerAdapter(`object`) , ZRecyclerData {
    override fun convert(holder: RecyclerViewHolder, position: Int, context: Context) {
        var entity = getEntity<String>(position)
        var scroll_item = holder.getTView<ZHAutoScrollView>(R.id.scroll_item)
        var item_text = holder.getTView<TextView>(R.id.item_text)
        var rightLayout = holder.getView(R.id.right_Layout)
        item_text.text = entity
        if (position % 2 == 0) {
            scroll_item.setIsCanScroll(false)
        } else {
            scroll_item.setIsCanScroll(true)
        }
        item_text.setOnClickListener {
            Toast.makeText(context, "点击$position", Toast.LENGTH_SHORT).show()
        }
        rightLayout.setOnClickListener {
            Log.e("点击", "删除 $entity")
            baseDatas.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, baseDatas.size - 1)
        }
    }

    override fun getLayoutResId(): Int {
        return R.layout.rv_left_del_layout
    }
}