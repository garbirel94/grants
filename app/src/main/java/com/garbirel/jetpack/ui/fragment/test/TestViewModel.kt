package com.garbirel.jetpack.ui.fragment.test

import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.StringObservableField

class TestViewModel : BaseViewModel(){
    var name = StringObservableField("正在获取中")
}