package com.garbirel.jetpack.ui.fragment.home

import androidx.lifecycle.MutableLiveData
import com.garbirel.jetpack.model.bean.ArticleResponse
import com.garbirel.jetpack.model.bean.BannerResponse
import com.garbirel.jetpack.network.HttpRequestCoroutine
import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import com.garbirel.jetpack.network.apiService
import com.garbirel.jetpack.network.stateCallback.ListDataUiState
import me.hgj.jetpackmvvm.ext.request
import me.hgj.jetpackmvvm.state.ResultState

class RequestHomeViewModel : BaseViewModel(){
    var pageNo = 0

    //首页文章列表数据
    var homeData: MutableLiveData<ListDataUiState<ArticleResponse>> = MutableLiveData()

    //首页轮播图数据
    var bannerData: MutableLiveData<ResultState<ArrayList<BannerResponse>>> = MutableLiveData()

    fun getBannerData() {
        request({ apiService.getBanner() }, bannerData)
    }

    fun getHomeData(isRefresh : Boolean) {
        if(isRefresh) {
            pageNo = 0
        }
        request({ HttpRequestCoroutine.getHomeData(pageNo)},{
            pageNo++
            homeData.value = ListDataUiState(
                isSuccess = true,
                isRefresh = isRefresh,
                isEmpty = it.isEmpty(),
                hasMore = it.hasMore(),
                isFirstEmpty = isRefresh && it.isEmpty(),
                listData = it.datas
            )
        },{
            homeData.value = ListDataUiState(
                isSuccess = false,
                errMessage = it.errorMsg,
                isRefresh = false,
                listData = arrayListOf<ArticleResponse>()
            )
        })
    }
}