package com.m2f.wallapop.presentation.comics

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.m2f.wallapop.R

class ComicListActivity : AppCompatActivity(), (Int) -> Unit {

    override fun invoke(position: Int) {
        if (mTwoPane) {
            val arguments = Bundle()
            arguments.putInt(ComicDetailFragment.COMIC_ID, position)
            val fragment = ComicDetailFragment()
            fragment.arguments = arguments
            supportFragmentManager.beginTransaction()
                    .replace(R.id.comic_detail_container, fragment)
                    .commit()
        } else {
            val intent = Intent(this, ComicDetailActivity::class.java)
            intent.putExtra(ComicDetailFragment.COMIC_ID, position)

            this.startActivity(intent)
        }
    }

    private var mTwoPane: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_list)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

    }
}
