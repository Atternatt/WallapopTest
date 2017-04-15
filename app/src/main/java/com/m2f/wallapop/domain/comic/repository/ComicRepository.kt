package com.m2f.wallapop.domain.comic.repository

import com.m2f.wallapop.domain.comic.model.ComicList
import io.reactivex.Flowable

/**
 * @author Marc Moreno
 * @version 1
 */
interface ComicRepository {

    fun getComicsForCharacter(characterId: Int): Flowable<ComicList>
}