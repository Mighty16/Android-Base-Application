package com.vv.api.rx

import com.vv.api.models.ItemApiModel
import com.vv.api.retrofit.RetrofitServiceProvider
import io.reactivex.Single


class RxApiServiceImpl(retrofitServiceProvider: RetrofitServiceProvider) : ApiService {

    private val retrofitService = retrofitServiceProvider.provideApiService()

    override fun getItems(): Single<List<ItemApiModel>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}