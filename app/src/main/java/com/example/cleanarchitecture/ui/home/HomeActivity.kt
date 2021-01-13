package com.example.cleanarchitecture.ui.home

import android.os.Bundle
import com.example.cleanarchitecture.databinding.ActivityHomeBinding
import com.example.core.data.model.WeatherResponse
import com.example.cleanarchitecture.ui.base.BaseActivity
import com.example.core.utils.toast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : BaseActivity<ActivityHomeBinding,HomeViewModel>() {

    override fun getViewModelClass(): Class<HomeViewModel> = HomeViewModel::class.java

    override fun getViewBinding() = ActivityHomeBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    fun initView(){
        val binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getWeather()
        setObservables(binding)
    }

    fun setObservables(binding: ActivityHomeBinding){
        viewModel.getWeatherResponse().observe(this){
            when(it){
                is String -> {
                    toast(it)
                }
                is WeatherResponse ->{
                    val response : WeatherResponse = it as WeatherResponse
                    binding.textView.text = response.name
                    binding.textView2.text = response.main?.temp.toString()

                }

            }

        }

    }
}