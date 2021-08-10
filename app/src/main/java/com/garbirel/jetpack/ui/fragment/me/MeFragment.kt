package com.garbirel.jetpack.ui.fragment.me

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseFragment
import com.garbirel.jetpack.databinding.FragmentMeBinding
import com.garbirel.jetpack.ext.jumpByLogin
import com.garbirel.jetpack.model.bean.IntegralResponse
import kotlinx.android.synthetic.main.fragment_me.*
import me.hgj.jetpackmvvm.ext.nav
import me.hgj.jetpackmvvm.ext.parseState
import me.hgj.jetpackmvvm.ext.util.notNull

class MeFragment : BaseFragment<MeViewModel,FragmentMeBinding>(){
    private var rank: IntegralResponse? = null

    override fun layoutId() = R.layout.fragment_me

    private val requestMeViewModel: RequestMeViewModel by viewModels()

    override fun initView(savedInstanceState: Bundle?) {
        mDatabind.vm = mViewModel
        mDatabind.click = ProxyClick()
        appViewModel.userinfo.value?.let {
            mViewModel.name.set(if(it.nickname.isEmpty()) it.username else it.nickname)
        }
    }

    override fun lazyLoadData() {
        super.lazyLoadData()
        appViewModel.userinfo.value?.run {
            me_swipe.isRefreshing = true
            requestMeViewModel.getIntegral()
        }
    }

    override fun createObserver() {
        super.createObserver()
        requestMeViewModel.meData.observe(viewLifecycleOwner, Observer { data  ->
            me_swipe.isRefreshing = false
            parseState(data, {
                rank = it
                mViewModel.info.set("id : ${it.userId} 排名 : ${it.rank}")
                mViewModel.integral.set(it.coinCount)
            })
        })
        appViewModel.run {
            userinfo.observe(viewLifecycleOwner, Observer {
                it.notNull({
                    me_swipe.isRefreshing = true
                    mViewModel.name.set(if (it.nickname.isEmpty()) it.username else it.nickname)
                    requestMeViewModel.getIntegral()
                },{
                    mViewModel.name.set("请先登录~")
                    mViewModel.info.set("id：--　排名：--")
                    mViewModel.integral.set(0)
                })
            })
        }
    }

    inner class ProxyClick {
        fun login() {
            nav().jumpByLogin {}
        }
        fun integral() {

        }
        fun collect() {

        }
        fun article() {

        }
        fun todo() {

        }
        fun about() {

        }
        fun join() {

        }
        fun demo() {

        }
        fun setting() {

        }
    }
}