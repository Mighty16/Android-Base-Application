package com.vv.app

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import java.lang.NullPointerException

open class BaseActivity : AppCompatActivity() {

    protected fun setUpToolbar(title: String, showBackArrow: Boolean = false): Toolbar {
        val localToolbar = findViewById<Toolbar>(R.id.toolbar)
            ?: throw NullPointerException("Toolbar with id R.id.toolbar was not found")

        localToolbar.title = title
        setSupportActionBar(localToolbar)
        if (showBackArrow) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            supportActionBar?.setDisplayShowHomeEnabled(true)
            localToolbar.setNavigationOnClickListener {
                onBackPressed()
            }
        } else {
            supportActionBar?.setDisplayHomeAsUpEnabled(false)
            supportActionBar?.setDisplayShowHomeEnabled(false)
        }
        return localToolbar
    }
}