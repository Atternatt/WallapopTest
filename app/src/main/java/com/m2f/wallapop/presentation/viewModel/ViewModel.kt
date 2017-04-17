package com.m2f.wallapop.presentation.viewModel


/**
 * @author Marc Moreno
 * @version 1
 *
 * Interface representing a ViewModel in a MVVM pattern
 */
interface ViewModel {

    fun onPause()

    fun onResume()

    fun onDestroy() {
    }
}