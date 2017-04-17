package com.m2f.wallapop.presentation.comics

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.m2f.wallapop.R

class ComicDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_detail)
        val toolbar = findViewById(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)

        if (savedInstanceState == null) {
            val arguments = Bundle()
            arguments.putString(ComicDetailFragment.COMIC_ID, intent.getStringExtra(
                    ComicDetailFragment.COMIC_ID))
            val fragment = ComicDetailFragment()
            fragment.arguments = arguments
            fragmentManager.beginTransaction().add(R.id.comic_detail_container, fragment).commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            navigateUpTo(Intent(this, ComicListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
