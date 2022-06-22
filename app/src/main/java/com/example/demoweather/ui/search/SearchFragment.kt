package com.example.demoweather.ui.search

import androidx.navigation.fragment.findNavController
import com.example.demoweather.R
import com.example.demoweather.base.BaseFragment
import com.example.demoweather.databinding.FragmentSearchBinding
import kotlinx.android.synthetic.main.fragment_search.*

class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    override val layoutId: Int
        get() = R.layout.fragment_search

    override fun initView() {
        val navController = findNavController()
        txt.setOnClickListener {
            navController.navigate(R.id.action_open_detailFragment)
        }
    }

    override fun setupObserver() {

    }

}