package com.example.cleanarchitecture.ui.base

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel

abstract class BaseViewModel: ViewModel(), LifecycleObserver {

    override fun onCleared() {
        super.onCleared()
    }
}