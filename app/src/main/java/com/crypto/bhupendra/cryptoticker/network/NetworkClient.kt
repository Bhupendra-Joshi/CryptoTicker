package com.crypto.bhupendra.cryptoticker.network

import com.crypto.bhupendra.cryptoticker.BuildConfig
import com.crypto.bhupendra.cryptoticker.network.models.Response
import io.reactivex.Observable
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by bhupendra on 16/12/17.
 */
class NetworkClient {
    private val iApi: IApi
    private val intercepter: HttpLoggingInterceptor = HttpLoggingInterceptor()

    init {
        intercepter.setLevel(HttpLoggingInterceptor.Level.BODY)
        var clientBuilder: OkHttpClient.Builder = OkHttpClient.Builder();
        clientBuilder.addInterceptor(intercepter);

        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(clientBuilder.build())
                .build()

        iApi = retrofit.create(IApi::class.java)
    }

    fun getTicker(cookie: String, userAgent: String): Observable<Response> {
        return iApi.getTicker(cookie, userAgent)
    }
}