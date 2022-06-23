package com.example.demoweather.ui

import android.util.Log
import androidx.activity.viewModels
import com.example.demoweather.BR
import com.example.demoweather.R
import com.example.demoweather.base.BaseActivity
import com.example.demoweather.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val layoutId: Int
        get() = R.layout.activity_main

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: MainViewModel by viewModels()

    override fun initView() {
    }


    override fun setupObserver() {
    }
}