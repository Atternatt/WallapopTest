package com.m2f.wallapop.presentation.comics

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import com.m2f.wallapop.R
import com.m2f.wallapop.databinding.ActivityComicListBinding
import com.m2f.wallapop.main.extensions.appComponent
import com.m2f.wallapop.presentation.BindableBaseActivity
import com.m2f.wallapop.presentation.viewModel.ViewModel
import javax.inject.Inject

class ComicListActivity : BindableBaseActivity<ComicComponent, ActivityComicListBinding>(), (Int) -> Unit {


    @Inject lateinit var viewModel: ComicListViewModel

    override fun invoke(position: Int) {
        if (mTwoPane) {
            val arguments = Bundle()
            arguments.putInt(ComicDetailFragment.COMIC_ID, position)
            val fragment = ComicDetailFragment()
            fragment.arguments = arguments
            fragmentManager.beginTransaction()
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
        setActionBar(toolbar)
        toolbar.title = title

    }

    override val component: ComicComponent
    get() {
      return DaggerComicComponent.builder()
              .applicationComponent(appComponent)
              .build()
    }

    override fun viewModel(): ViewModel {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun layout(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun id(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
