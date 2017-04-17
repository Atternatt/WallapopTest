package com.m2f.wallapop.presentation.comics

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.m2f.wallapop.R

class ComicDetailFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (arguments.containsKey(COMIC_ID)) {

            val activity = this.activity
            val appBarLayout = activity.findViewById(R.id.toolbar_layout) as CollapsingToolbarLayout
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater!!.inflate(R.layout.comic_detail, container, false)

        return rootView
    }

    companion object {
        val COMIC_ID = "item_id"
    }
}
