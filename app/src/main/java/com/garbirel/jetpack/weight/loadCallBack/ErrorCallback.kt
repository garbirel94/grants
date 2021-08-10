package com.garbirel.jetpack.weight.loadCallBack

import com.garbirel.jetpack.R
import com.kingja.loadsir.callback.Callback


class ErrorCallback : Callback() {

    override fun onCreateView(): Int {
        return R.layout.layout_error
    }

}