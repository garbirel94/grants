package com.garbirel.jetpack.ui.main

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.Observer
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseActivity
import com.garbirel.jetpack.databinding.ActivityMainBinding
import me.hgj.jetpackmvvm.demo.app.util.StatusBarUtil

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>(){
    override fun layoutId() = R.layout.activity_main

    override fun initView(savedInstanceState: Bundle?) {
        appViewModel.appColor.value?.let {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
            supportActionBar?.setBackgroundDrawable(ColorDrawable(it))
            StatusBarUtil.setColor(this, it, 0) }
    }

    override fun createObserver() {
        appViewModel.appColor.observe(this, Observer {
            supportActionBar?.setBackgroundDrawable(ColorDrawable(it))
            StatusBarUtil.setColor(this, it, 0)
        })
    }
}