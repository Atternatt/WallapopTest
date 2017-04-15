package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.domain.comic.model.ComicList
import com.m2f.wallapop.domain.comic.repository.ComicRepository
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * @author Marc Moreno
 * @version 1
 */
class ComicRepositoryImpl
@Inject constructor(vararg val comicDatasource: ComicDatasource): ComicRepository {

    override fun getComicsForCharacter(characterId: Int): Flowable<ComicList> {
        return Flowable.merge(comicDatasource.map { it.getComicsForCharacter(characterId) })
                .map { it.comics }
                .first(ComicList(0, "", listOf()))
                .toFlowable()
    }
}