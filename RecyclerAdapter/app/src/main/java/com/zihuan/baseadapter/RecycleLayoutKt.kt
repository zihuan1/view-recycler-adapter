package com.zihuan.baseadapter

import android.annotation.SuppressLint
import android.content.Context
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

@SuppressLint("StaticFieldLeak")
object RecycleLayoutKt {
   private var mContext: Context? = null

    //横向布局
    fun RecyclerView.initHorizontal() {
        mContext = this.context
        this.layoutManager = RecycleViewBuilder.getLinLayoutManager(LinearLayoutManager.HORIZONTAL, this)
    }

    fun RecyclerView.initHorizontal(adapter: RecyclerView.Adapter<*>) {
        initHorizontal()
        this.adapter = adapter
    }


    //竖向布局
    fun RecyclerView.initVertical(): LinearLayoutManager {
        mContext = this.context
        this.layoutManager = RecycleViewBuilder.getLinLayoutManager(LinearLayoutManager.VERTICAL, this)
        return this.layoutManager as LinearLayoutManager
    }

    fun RecyclerView.initVertical(adapter: RecyclerView.Adapter<*>) {
        initVertical()
        this.adapter = adapter
    }


    fun RecyclerView.initGrid(count: Int): GridLayoutManager {
        mContext = this.context
        this.layoutManager = RecycleViewBuilder.getGridLayoutManager(count, this)
        return this.layoutManager as GridLayoutManager
    }

    fun RecyclerView.initGrid(count: Int, adapter: RecyclerView.Adapter<*>) {
        initGrid(count)
        this.adapter = adapter
    }


    private object RecycleViewBuilder {
        /***
         * orientation 0横向 1竖向
         */
        fun getLinLayoutManager(orientation: Int, view: RecyclerView): LinearLayoutManager {
            val layoutManager = object : LinearLayoutManager(mContext) {
                override fun onLayoutChildren(recycler: RecyclerView.Recycler?, state: RecyclerView.State?) {
                    super.onLayoutChildren(recycler, state)
                }
            }
            view.isNestedScrollingEnabled = false
            layoutManager.orientation = orientation
            return layoutManager
        }

        fun getGridLayoutManager(count: Int, view: RecyclerView): GridLayoutManager {
            view.isNestedScrollingEnabled = false
            return GridLayoutManager(mContext, count)
        }
    }


}