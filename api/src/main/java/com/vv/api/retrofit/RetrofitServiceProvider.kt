package com.vv.api.retrofit

import com.vv.api.rx.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceProvider(config:Config = Config()) {

    private val retrofitBuilder = Retrofit.Builder()
            .addCallAdapterFactory(config.callAdapterFactory)
            .addConverterFactory(config.converterFactory)
            .client(config.client ?: buildHttpClient(config))
            .baseUrl(config.baseUrl)
            .build()

    fun provideApiService():ApiService{
        return retrofitBuilder.create(ApiService::class.java)
    }

    private fun buildHttpClient(config: Config): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (config.enableLog) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        if (config.useUntrustedSSL){

        }
        return builder.build()
    }

    data class Config(
        val baseUrl:String = "",
        val client: OkHttpClient? = null,
        val enableLog: Boolean = true,
        val useUntrustedSSL: Boolean = false,
        val callAdapterFactory: CallAdapter.Factory = RxJava2CallAdapterFactory.create(),
        val converterFactory: Converter.Factory =  GsonConverterFactory.create()
    )
}