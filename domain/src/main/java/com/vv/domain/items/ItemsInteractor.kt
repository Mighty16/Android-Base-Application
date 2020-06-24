package com.vv.domain.items

interface ItemsInteractorContract {

    fun getAllItems(): List<ItemEntity>

}

class ItemsInteractor(private val itemsRepository: ItemsRepositoryContract):ItemsInteractorContract{

    override fun getAllItems(): List<ItemEntity> {
       return itemsRepository.getAll()
    }

}