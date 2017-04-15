package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.domain.comic.model.ComicResult
import io.reactivex.Flowable

/**
 * @author Marc Moreno
 * @version 1
 */
interface ComicDatasource {

    fun getComicsForCharacter(characterId: Int): Flowable<ComicResult>
}