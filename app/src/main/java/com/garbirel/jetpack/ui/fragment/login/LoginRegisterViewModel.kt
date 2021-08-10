package com.garbirel.jetpack.ui.fragment.login

import me.hgj.jetpackmvvm.base.viewmodel.BaseViewModel
import me.hgj.jetpackmvvm.callback.databind.StringObservableField
import me.hgj.jetpackmvvm.callback.livedata.StringLiveData

class LoginRegisterViewModel : BaseViewModel() {
    var userName = StringLiveData()

    var password = StringObservableField()

    var password2 = StringObservableField()
}