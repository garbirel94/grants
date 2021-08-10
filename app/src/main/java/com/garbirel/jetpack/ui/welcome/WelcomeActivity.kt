package com.garbirel.jetpack.ui.welcome

import android.content.Intent
import android.os.Bundle
import com.garbirel.jetpack.R
import com.garbirel.jetpack.base.BaseActivity
import com.garbirel.jetpack.databinding.ActivityWelcomeBinding
import com.garbirel.jetpack.ui.main.MainActivity
import com.garbirel.jetpack.util.CacheUtil
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel

class WelcomeActivity : BaseActivity<BaseViewModel, ActivityWelcomeBinding>(){

    override fun layoutId() = R.layout.activity_welcome

    override fun initView(savedInstanceState: Bundle?) {
        /**
         * 需要绑定，否则点击事件无效
         * */
        mDatabind.click = ProxyClick()
    }

    inner class ProxyClick {
        fun toMain() {
            CacheUtil.setFirst(false)
            startActivity(Intent(this@WelcomeActivity, MainActivity::class.java))
            finish()
            //带点渐变动画
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}