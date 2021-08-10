package com.garbirel.jetpack.ui.fragment.me

import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.IntObservableField
import me.hgj.jetpackmvvm.callback.databind.StringObservableField
import me.hgj.jetpackmvvm.demo.app.util.ColorUtil

class MeViewModel : BaseViewModel(){
    var name = StringObservableField("请先登陆")
    var imageUrl = StringObservableField(ColorUtil.randomImage())
    var info = StringObservableField("id : --  排名: -- ")
    var integral = IntObservableField(0)
}