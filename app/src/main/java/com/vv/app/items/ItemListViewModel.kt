package com.vv.app.items

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vv.domain.items.ItemsRepositoryContract

class ItemListViewModel @ViewModelInject constructor(private val itemsInteractor: ItemsRepositoryContract): ViewModel() {

    private val itemsData = MutableLiveData<List<ListItem>>()

    fun getItems() {
        if (itemsData.value != null) return
        itemsData.value = itemsInteractor.getAll().map { ListItem(it) }
    }

    fun itemData(): LiveData<List<ListItem>> {
        return itemsData
    }



}