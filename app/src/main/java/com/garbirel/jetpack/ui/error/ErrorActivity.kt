package com.garbirel.jetpack.ui.error

import android.os.Bundle
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseActivity
import com.garbirel.jetpack.databinding.LayoutErrorBinding
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

class ErrorActivity : BaseActivity<BaseViewModel, LayoutErrorBinding>(){
    override fun layoutId() = R.layout.layout_error

    override fun initView(savedInstanceState: Bundle?) {

    }
}