package com.m2f.wallapop

import com.m2f.wallapop.data.comics.repository.CloudComicDatasource
import com.m2f.wallapop.main.di.NetworkModule
import org.junit.Test

/**
 * @author Marc Moreno
 * @version 1
 */
class GetComicsTests {

    val networkModule = NetworkModule()

    val retrofit = networkModule.providesRetrofit(
            networkModule.providesHttpClient(networkModule.providesInterceptor()))

    val datasource = CloudComicDatasource(retrofit)

    @Test fun testGetComicsCompletes() {
        datasource.getComicsForCharacter(1009220)
                .test()
                .assertComplete()
    }

    @Test fun testGetComicsNoErrors() {
        datasource.getComicsForCharacter(1009220)
                .test()
                .assertNoErrors()
    }

    @Test fun testGetComicsNotEmpty() {
        datasource.getComicsForCharacter(1009220)
                .test()
                .assertValue { it.isNotEmpty()}
    }
}