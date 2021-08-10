package com.garbirel.jetpack.ui.fragment.login

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentLoginBinding
import com.garbirel.jetpack.ext.hideSoftKeyboard
import com.garbirel.jetpack.ext.initClose
import com.garbirel.jetpack.ext.showMessage
import com.garbirel.jetpack.util.CacheUtil
import kotlinx.android.synthetic.main.include_toolbar.*
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.navigateAction
import me.hgj.jetpackmvvm.ext.parseState

class LoginFragment : BaseFragment<LoginRegisterViewModel, FragmentLoginBinding>(){
    private val requestLoginRegisterViewModel: RequestLoginRegisterViewModel by viewModels()

    override fun layoutId() = R.layout.fragment_login

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.click = ProxyClick()
        mDatabind.viewModel = mViewModel

        toolbar.initClose("登陆") {
            nav().navigateUp()
        }
    }

    override fun createObserver() {
        super.createObserver()
        requestLoginRegisterViewModel.loginResult.observe(viewLifecycleOwner, Observer {result ->
            parseState(result, {
                CacheUtil.setUser(it)
                CacheUtil.setIsLogin(true)
                appViewModel.userinfo.value = it
                nav().navigateUp()
            }, {
                showMessage(it.errorMsg)
            })
        })
    }

    inner class ProxyClick {
        fun login() {
            when {
                mViewModel.userName.value.isEmpty() -> showMessage("请填写账号")
                mViewModel.password.get().isEmpty() -> showMessage("请填写密码")
                else -> requestLoginRegisterViewModel.login(
                    mViewModel.userName.value,
                    mViewModel.password.get()
                )
            }
        }

        fun toRegister() {
            hideSoftKeyboard(activity)
            nav().navigateAction(R.id.action_loginFragment_to_registerFragment)
        }
    }
}