package com.example.demoweather.ui.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.demoweather.BR
import com.example.demoweather.R
import com.example.demoweather.base.BaseFragment
import com.example.demoweather.databinding.FragmentSearchBinding
import com.example.demoweather.ui.MainViewModel
import com.example.demoweather.util.Keys
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import java.util.concurrent.TimeUnit

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {

    companion object {
        val TAG = "SearchFragment"
    }

    override val layoutId: Int
        get() = R.layout.fragment_search

    var adapter: ListCityAdapter? = null

    val activityViewModel: MainViewModel by activityViewModels()

    val viewModel: SearchViewModel by viewModels()
    var navController: NavController? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.setVariable(BR.viewModel, viewModel)
        viewBinding.executePendingBindings()
    }

    @SuppressLint("CheckResult")
    override fun initView() {
        navController = findNavController()
        rv_list_city.layoutManager = LinearLayoutManager(requireContext())
        RxSearchObservable.fromView(edt_search)
            .debounce(200, TimeUnit.MILLISECONDS)
            .filter { text ->
                text.isNotEmpty()
            }
            .distinctUntilChanged()
            .switchMap {
                activityViewModel.cityRepository.searchCityData(it)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                activityViewModel.listCityResult.value = it ?: mutableListOf()
            }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun setupObserver() {
        activityViewModel.listCityResult.observe(viewLifecycleOwner) {
            adapter = ListCityAdapter(it ?: mutableListOf()) {
                val bundle = bundleOf(Keys.CITY_DATA to it)
                navController?.navigate(R.id.action_open_detailFragment, bundle)
            }
            rv_list_city.adapter = adapter
            adapter?.notifyDataSetChanged()
        }
    }

}