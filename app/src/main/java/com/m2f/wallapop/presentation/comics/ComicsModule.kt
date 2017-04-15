package com.m2f.wallapop.presentation.comics

import com.m2f.wallapop.data.comics.repository.CloudComicDatasource
import com.m2f.wallapop.data.comics.repository.ComicDatasource
import com.m2f.wallapop.data.comics.repository.ComicRepositoryImpl
import com.m2f.wallapop.domain.comic.repository.ComicRepository
import com.m2f.wallapop.main.di.CustomScope
import dagger.Module
import dagger.Provides

/**
 * @author Marc Moreno
 * @version 1
 */
@Module
class ComicsModule {

    @Provides
    @CustomScope
    fun provideDatasources(cloudComicDatasource: CloudComicDatasource): Array<ComicDatasource> {
        return arrayOf(cloudComicDatasource)
    }

    @Provides
    @CustomScope
    fun providesConcertRepository(concertRepositoryImpl: ComicRepositoryImpl): ComicRepository {
        return concertRepositoryImpl
    }
}