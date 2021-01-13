package com.example.cleanarchitecture.ui.home

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.cleanarchitecture.ui.base.BaseViewModel
import com.example.core.domain.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeViewModel @ViewModelInject constructor(private val repository: Repository) : BaseViewModel() {

    val cityName = "London"
    val key = "Add Key here"

//    @Inject
//    lateinit var repository: Repository

    private val getWeatherResponse: MutableLiveData<Any> = MutableLiveData()
    fun getWeatherResponse() : LiveData<Any> = getWeatherResponse


    fun getWeather(){
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                repository.weatherResponse(cityName,key)
            }.onSuccess {
                withContext(Dispatchers.Main){
                    if(it.isSuccessful){
//                        Log.e("viewmodel",it.body.name)
                        getWeatherResponse.postValue(it.body())
                    } else{
                        getWeatherResponse.postValue("not successful")
                        Log.e("viewmodel", "not successful")
                    }
                }
            }.onFailure {
                getWeatherResponse.postValue(it.message)
                Log.e("viewmodel", it.message!!)
            }
        }
    }
}