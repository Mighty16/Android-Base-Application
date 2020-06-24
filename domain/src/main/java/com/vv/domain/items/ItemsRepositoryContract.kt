package com.vv.domain.items

import com.vv.domain.items.ItemEntity

interface ItemsRepositoryContract {

    fun getAll(): List<ItemEntity>

}
