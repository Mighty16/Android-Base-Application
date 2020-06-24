package com.vv.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vv.data.items.ItemDao
import com.vv.data.items.ItemDataEntity

@Database(version = 1,entities = [ItemDataEntity::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun itemDao(): ItemDao

}