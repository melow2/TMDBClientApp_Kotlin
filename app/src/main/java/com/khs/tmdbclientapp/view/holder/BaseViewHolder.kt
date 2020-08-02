package com.khs.tmdbclientapp.view.holder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 *
 *@auther hyeoksin
 *@since
 * */

abstract class BaseViewHolder:RecyclerView.ViewHolder{
    private lateinit var context:Context
    constructor(context:Context,view: View):super(view){
        this.context = context
    }
    abstract fun bindDataToViewHolder()
}
