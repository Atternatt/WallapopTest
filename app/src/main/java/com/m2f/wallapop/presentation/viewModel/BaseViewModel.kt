package com.m2f.wallapop.presentation.viewModel

import android.databinding.BaseObservable
import com.m2f.wallapop.presentation.viewModel.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.plusAssign

/**
 * @author Marc Moreno
 * @version 1
 */
abstract class BaseViewModel : ViewModel, BaseObservable() {

    private val compositeDisposable = CompositeDisposable()

    abstract var interactorList: List<Disposable>

    operator fun plusAssign(disposable: Disposable) {
        compositeDisposable += disposable
    }

    override fun onResume() {
        interactorList.forEach { compositeDisposable += it }
    }

    override fun onPause() {}

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.dispose()
    }
}