package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.data.comics.model.toBO
import com.m2f.wallapop.domain.comic.model.ComicResult
import io.reactivex.Flowable
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * @author Marc Moreno
 * @version 1
 */
class CloudComicDatasource
@Inject constructor(retrofit: Retrofit): ComicDatasource {

    val gateway = retrofit.create(ComicsGateway::class.java)

    override fun getComicsForCharacter(characterId: Int): Flowable<ComicResult> {
        return gateway.getComicsForCharacter(characterId)
                .filter { !it.isError && it.response().isSuccessful }
                .map { it.response().body().toBO() }
    }
}