package com.garbirel.jetpack.model.bean

import android.annotation.SuppressLint
import android.os.Parcelable
import com.garbirel.jetpack.model.bean.ArticleResponse
import kotlinx.android.parcel.Parcelize

/**
 * 导航数据
  * @Author:         hegaojian
  * @CreateDate:     2019/8/26 17:40
 */
@SuppressLint("ParcelCreator")
@Parcelize
data class NavigationResponse(var articles: ArrayList<ArticleResponse>,
                              var cid: Int,
                              var name: String) : Parcelable
