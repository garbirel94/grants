package com.garbirel.jetpack.ui.fragment.main

import android.graphics.Bitmap
import android.os.Bundle
import androidx.lifecycle.Observer
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentMainBinding
import com.garbirel.jetpack.ext.init
import com.garbirel.jetpack.ext.initMain
import com.garbirel.jetpack.ext.interceptLongClick
import com.garbirel.jetpack.ext.setUiTheme
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment<MainViewModel, FragmentMainBinding>() {

    override fun layoutId() = R.layout.fragment_main

    override fun initView(savedInstanceState: Bundle?) {
        mainViewpager.initMain(this)

        mainBottom.init {
            when(it) {
                R.id.menu_home -> mainViewpager.setCurrentItem(0,false)
                R.id.menu_bookshelf -> mainViewpager.setCurrentItem(1,false)
                R.id.menu_account -> mainViewpager.setCurrentItem(2,false)
            }
        }
        mainBottom.interceptLongClick(R.id.menu_account,R.id.menu_bookshelf,R.id.menu_home)
    }

    override fun createObserver() {
        appViewModel.appColor.observe(viewLifecycleOwner, Observer {
            setUiTheme(it, mainBottom)
        })
    }
}