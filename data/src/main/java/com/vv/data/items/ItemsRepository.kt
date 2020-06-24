package com.vv.data.items

import com.vv.data.AppDatabase
import com.vv.domain.common.SimpleMapper
import com.vv.domain.items.ItemEntity
import com.vv.domain.items.ItemsRepositoryContract

class ItemsRepository(
    roomDatabase: AppDatabase,
    private val dataEntityMapper: SimpleMapper<ItemDataEntity, ItemEntity>
) : ItemsRepositoryContract {

    private val itemsDao = roomDatabase.itemDao()

    override fun getAll(): List<ItemEntity> {
        //return dataEntityMapper.map(itemsDao.getAll())

        return listOf(
            createTestItem("1"),
            createTestItem("2"),
            createTestItem("3"),
            createTestItem("4"),
            createTestItem("5"),
            createTestItem("6"),
            createTestItem("7"),
            createTestItem("8"),
            createTestItem("9"),
            createTestItem("10")
        )

    }


    private fun createTestItem(id: String): ItemEntity {
        return ItemEntity(
            id = id,
            title = "Item $id title",
            description = "Item $id description",
            imageUrl = ""
        )
    }


}