package com.vv.api.rx

import com.vv.api.models.ItemApiModel
import io.reactivex.Single

interface ApiService {

    fun getItems(): Single<List<ItemApiModel>>

}