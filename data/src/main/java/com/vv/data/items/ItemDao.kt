package com.vv.data.items

import androidx.room.Dao
import androidx.room.Query
import com.vv.data.items.ItemDataEntity

@Dao
interface ItemDao {

    @Query("SELECT * FROM items ")
    fun getAll():List<ItemDataEntity>

}