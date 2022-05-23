package com.yogigupta1206.trendingrepos

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.yogigupta1206.trendingrepos.databinding.ActivityMainBinding
import com.yogigupta1206.trendingrepos.ui.main.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        initializeData()
    }

    private fun initializeData() {
        TODO("Not yet implemented")
    }
}