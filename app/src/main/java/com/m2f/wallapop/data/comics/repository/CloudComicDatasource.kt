package com.m2f.wallapop.data.comics.repository

import com.m2f.wallapop.data.comics.model.toBO
import com.m2f.wallapop.data.extractResult
import com.m2f.wallapop.domain.comic.model.Comic
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

    override fun getComicsForCharacter(characterId: Int): Flowable<List<Comic>> {
        return gateway.getComicsForCharacter(characterId)
                .extractResult()
                .map { it.data.results.map { it.toBO() } }
    }

    fun getComicsForCharacterRawString(characterId: Int): Flowable<String> {
        return gateway.getComicsForCharacterRawString(characterId)
                .extractResult()
                .map { it }
    }

}