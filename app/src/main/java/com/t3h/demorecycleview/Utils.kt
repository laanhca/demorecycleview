package com.t3h.demorecycleview

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class Utils{
    //cac phuong thuc, thuoc tinh se nam trong companion object
    companion object{
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(iv:ImageView,link:String){
           if(link.equals("")){
               Glide.with(iv).load(R.drawable.aodai).into(iv)
          }else{
                Glide.with(iv).load(link).placeholder(R.drawable.aodai).error(R.drawable.aodai).into(iv)
            }
        }
    }
}