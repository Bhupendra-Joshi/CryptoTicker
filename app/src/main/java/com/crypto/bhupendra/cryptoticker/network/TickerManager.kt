package com.crypto.bhupendra.cryptoticker.network

import android.util.Log
import com.crypto.bhupendra.cryptoticker.OnUpdate
import com.crypto.bhupendra.cryptoticker.network.models.Response
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by bhupendra on 16/12/17.
 */
class TickerManager(private val callback: OnUpdate,
                    private val cookie: String,
                    private val userAgent: String,
                    private val networkClient: NetworkClient = NetworkClient()) {

    private var mCompositeDisposable: CompositeDisposable? = null

    fun getTicker() {
        mCompositeDisposable = CompositeDisposable()
        val news: Observable<Response> = networkClient.getTicker(cookie, userAgent)

        mCompositeDisposable?.add(news.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError))
    }

    private fun handleResponse(response: Response) {
        callback.onUpdateTicker(response)
        Thread.sleep(500)
        getTicker()

    }

    private fun handleError(error: Throwable) {
        Log.e("Error", error.toString())
    }
}