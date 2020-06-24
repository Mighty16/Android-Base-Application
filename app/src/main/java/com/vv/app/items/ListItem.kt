package com.vv.app.items

import coil.api.load
import com.vv.app.R
import com.vv.domain.items.ItemEntity
import com.xwray.groupie.kotlinandroidextensions.GroupieViewHolder
import com.xwray.groupie.kotlinandroidextensions.Item
import kotlinx.android.synthetic.main.list_item.*

class ListItem(private val itemEntity: ItemEntity) : Item() {

    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemTitle.text = itemEntity.title
        viewHolder.itemDescription.text = itemEntity.description
        viewHolder.itemIcon.load(itemEntity.imageUrl)
    }

    override fun getLayout(): Int = R.layout.list_item
}