package com.m2f.wallapop.main.extensions

import android.app.Activity
import com.m2f.wallapop.main.di.ApplicationComponent
import com.m2f.wallapop.presentation.WallapopApplication

/**
 * @author Marc Moreno
 * @version 1
 */

val Activity.appComponent: ApplicationComponent
    get() {
        return (this.application as WallapopApplication).applicationComponent
    }