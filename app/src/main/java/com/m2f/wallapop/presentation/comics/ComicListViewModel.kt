package com.m2f.wallapop.presentation.comics

import com.m2f.wallapop.domain.comic.GetComicsInteractor
import com.m2f.wallapop.presentation.viewModel.BaseViewModel
import io.reactivex.disposables.Disposable
import javax.inject.Inject

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicListViewModel
    @Inject constructor(getComicsInteractor: GetComicsInteractor): BaseViewModel() {

    override var interactorList: List<Disposable> = listOf(getComicsInteractor)
}