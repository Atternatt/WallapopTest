package com.m2f.wallapop.presentation.comics

import com.m2f.wallapop.main.di.ApplicationComponent
import com.m2f.wallapop.main.di.CustomScope
import com.m2f.wallapop.presentation.ComicDetailActivity
import com.m2f.wallapop.presentation.ComicListActivity
import dagger.Component

/**
 * @author Marc Moreno
 * @version 1
 */
@CustomScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ComicsModule::class))
interface ComicComponent {

    fun inject(activity: ComicDetailActivity)
    fun inject(activity: ComicListActivity)
}