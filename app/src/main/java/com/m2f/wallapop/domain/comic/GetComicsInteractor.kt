package com.m2f.wallapop.domain.comic

import com.m2f.wallapop.domain.comic.model.ComicList
import com.m2f.wallapop.domain.comic.repository.ComicRepository
import com.m2f.wallapop.domain.executor.PostExecutionThread
import com.m2f.wallapop.domain.interactor.BaseInteractor
import io.reactivex.Flowable
import java.util.concurrent.Executor
import javax.inject.Inject

/**
 * @author Marc Moreno
 * @version 1
 */
class GetComicsInteractor
@Inject constructor(postExecutionThread: PostExecutionThread,
                    threadExecutor: Executor,
                    val comicRepository: ComicRepository) : BaseInteractor<ComicList, Int>(postExecutionThread, threadExecutor) {

    override fun buildFlowable(param: Int): Flowable<ComicList> {
        return comicRepository.getComicsForCharacter(param)
    }
}