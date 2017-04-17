package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.data.comics.model.ComicDTO
import com.m2f.wallapop.domain.comic.model.Comic
import io.reactivex.Flowable

/**
 * @author Marc Moreno
 * @version 1
 */
interface ComicDatasource {

    fun getComicsForCharacter(characterId: Int): Flowable<List<Comic>>
}