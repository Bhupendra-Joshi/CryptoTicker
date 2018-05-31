package com.crypto.bhupendra.cryptoticker.network

import com.crypto.bhupendra.cryptoticker.network.models.Response
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by bhupendra on 16/12/17.
 */
interface IApi {
    @GET("/api/dashboards/ticker")
    fun getTicker(@Header("cookie") cookie: String, @Header("user-agent") userAgent: String): Observable<Response>

}