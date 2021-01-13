package com.example.cleanarchitecture.ui.base

import android.app.Dialog
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.example.cleanarchitecture.R
import com.example.cleanarchitecture.databinding.ActivityBaseBinding
import javax.inject.Inject


abstract class BaseActivity<B: ViewBinding, VM: ViewModel> : AppCompatActivity() {

    lateinit var viewModel: VM
    lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(getViewModelClass())
        binding = getViewBinding()
        setContentView(binding.root)
    }

    protected abstract fun getViewModelClass(): Class<VM>

    protected abstract fun getViewBinding(): B

    @Inject
    lateinit var sp: SharedPreferences

//    @Inject
//    lateinit var progressHUD: ProgressHUD
//
//    @Inject
//    lateinit var customPopups: CustomPopups


//    override fun onFragmentAttached() {
//    }
//
//    override fun onFragmentDetached(tag: String) {
//        val fragmentManager = supportFragmentManager
//        val fragment = fragmentManager.findFragmentByTag(tag)
//        if (fragment != null) {
//            fragmentManager
//                .beginTransaction()
//                .disallowAddToBackStack()
//                .setCustomAnimations(R.anim.slide_up, R.anim.slide_down)
//                .remove(fragment)
//                .commitNow()
//            fragmentManager.popBackStack()
//        }
//    }
//
//    fun showLoader(progressHUD: ProgressHUD){
//        progressHUD.showLoadingDialog()
//    }
//
//    fun hideLoader(progressHUD: Dialog){
//        if(progressHUD.isShowing)
//            progressHUD.dismiss()
//    }
}