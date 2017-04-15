package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.domain.comic.model.ComicResult
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Marc Moreno
 * @version 1
 */
interface ComicsGateway {

    @GET("v1/public/characters/{characterId}/comics")
    fun getComicsForCharacter(@Path("characterId") characterId: Int) : Flowable<ComicResult>
}