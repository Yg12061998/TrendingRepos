package com.yogigupta1206.trendingrepos.utils

import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.yogigupta1206.trendingrepos.R

@BindingAdapter("setAvatar")
fun AppCompatImageView.setAvatar(url:String?){
    if(!(url.isNullOrEmpty() || url.isNullOrBlank())){
        Glide.with(this.context).load(url).into(this)
    }
}

@BindingAdapter("setColor")
fun TextView.setColor(url:String?){
    url?.let {
        this.setColor(url)
    }
}