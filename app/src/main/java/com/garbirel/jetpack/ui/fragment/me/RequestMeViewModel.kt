package com.garbirel.jetpack.ui.fragment.me

import androidx.lifecycle.MutableLiveData
import com.garbirel.jetpack.model.bean.IntegralResponse
import com.garbirel.jetpack.network.apiService
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.state.ResultState

class RequestMeViewModel : BaseViewModel(){
    var meData = MutableLiveData<ResultState<IntegralResponse>>()

    fun getIntegral() {
        request({ apiService.getIntegral() }, meData)
    }
}