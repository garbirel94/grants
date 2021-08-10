package com.garbirel.jetpack.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentRegisterBinding
import com.garbirel.jetpack.ext.initClose
import kotlinx.android.synthetic.main.include_toolbar.*
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.parseState

class RegisterFragment : BaseFragment<LoginRegisterViewModel, FragmentRegisterBinding>(){

    private val requestLoginRegisterViewModel: RequestLoginRegisterViewModel by viewModels()

    override fun layoutId() = R.layout.fragment_register

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.click = ProxyClick()
        mDatabind.viewModel = mViewModel

        toolbar.initClose("注册") {
            nav().navigateUp()
        }
    }

    override fun createObserver() {
        super.createObserver()
        requestLoginRegisterViewModel.loginResult.observe(viewLifecycleOwner, Observer {result ->
            parseState(result, {

            }, {

            })
        })
    }

    inner class ProxyClick {
        fun register() {}
    }
}