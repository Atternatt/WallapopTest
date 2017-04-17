package com.m2f.wallapop.data.comics.repository

import com.jakewharton.retrofit2.adapter.rxjava2.Result
import com.m2f.wallapop.data.comics.model.ComicResponseDTO
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * @author Marc Moreno
 * @version 1
 */
interface ComicsGateway {

    @GET("v1/public/characters/{characterId}/comics")
    fun getComicsForCharacter(@Path("characterId") characterId: Int) : Flowable<Result<ComicResponseDTO>>

    @GET("v1/public/characters/{characterId}/comics")
    fun getComicsForCharacterRawString(@Path("characterId") characterId: Int) : Flowable<Result<String>>
}