package com.vv.data

import android.content.Context
import androidx.room.Room
import com.vv.data.items.ItemDataEntityMapper
import com.vv.data.items.ItemsRepository
import com.vv.domain.items.ItemsRepositoryContract

class ReposProvider(context: Context, databaseName: String) {

    private val roomDataBase: AppDatabase = Room.databaseBuilder(
        context, AppDatabase::class.java, databaseName
    ).build()

    private val itemsDataEntityMapper = ItemDataEntityMapper()

    fun provideItemsRepository(): ItemsRepositoryContract {
        return ItemsRepository(
            roomDataBase,
            itemsDataEntityMapper
        )
    }

}