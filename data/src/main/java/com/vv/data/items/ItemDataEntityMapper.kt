package com.vv.data.items

import com.vv.domain.common.SimpleMapper
import com.vv.domain.items.ItemEntity

class ItemDataEntityMapper : SimpleMapper<ItemDataEntity, ItemEntity> {
    override fun map(from: ItemDataEntity): ItemEntity {
        return ItemEntity(
            id = from.id,
            title = from.title,
            description = from.description,
            imageUrl = from.imageUrl
        )
    }
}