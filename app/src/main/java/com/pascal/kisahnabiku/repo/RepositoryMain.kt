package com.pascal.kisahnabiku.repo

import com.pascal.kisahnabiku.model.ResponseMain
import com.pascal.kisahnabiku.network.ConfigNetwork
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class RepositoryMain {

    fun getData(responhandler: (List<ResponseMain>) -> Unit, errrorHandler: (Throwable) -> Unit) {
        ConfigNetwork.service().getData().subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                responhandler(it)
            }, {
                errrorHandler(it)
            })
    }
}