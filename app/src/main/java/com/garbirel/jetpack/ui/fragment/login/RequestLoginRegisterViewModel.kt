package com.garbirel.jetpack.ui.fragment.login

import androidx.lifecycle.MutableLiveData
import com.garbirel.jetpack.model.bean.UserInfo
import com.garbirel.jetpack.network.HttpRequestCoroutine
import com.garbirel.jetpack.network.apiService
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.state.ResultState

class RequestLoginRegisterViewModel : BaseViewModel(){

    var loginResult = MutableLiveData<ResultState<UserInfo>>()

    fun login(userName: String, password: String) {
        request(
            { apiService.login(userName, password) }//请求体
            , loginResult,//请求的返回结果，请求成功与否都会改变该值，在Activity或fragment中监听回调结果，具体可看loginActivity中的回调
            true,//是否显示等待框，，默认false不显示 可以默认不传
            "正在登录中..."//等待框内容，可以默认不填请求网络中...
        )
    }

    fun register(userName : String, password: String) {
        request(
            { HttpRequestCoroutine.register(userName, password) }
            , loginResult,
            true,
            "正在注册中..."
        )
    }
}