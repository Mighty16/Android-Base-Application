package com.vv.app.items

import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.vv.app.BaseActivity
import com.vv.app.R
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_items_list.*

@AndroidEntryPoint
class ItemsListActivity : BaseActivity() {

    private val itemsViewModel: ItemListViewModel by viewModels()
    private val listAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items_list)
        setUpList()
        setUpViewModel()
    }

    private fun setUpList() {
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = listAdapter
    }

    private fun setUpViewModel() {
        itemsViewModel.itemData().observe(this, Observer { newItems ->
            listAdapter.update(newItems)
        })
    }

    override fun onStart() {
        super.onStart()
        itemsViewModel.getItems()
    }
}