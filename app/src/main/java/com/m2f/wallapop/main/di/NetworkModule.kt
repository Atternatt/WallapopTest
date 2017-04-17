package com.m2f.wallapop.main.di

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.m2f.wallapop.BuildConfig
import com.m2f.wallapop.main.extensions.md5
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.lang.reflect.Type
import java.util.*
import javax.inject.Singleton

/**
 * @author Marc Moreno
 * @version 1
 */
@Module
class NetworkModule {


    @Provides
    @Singleton
    fun providesInterceptor(): Interceptor {
        return Interceptor {
            val ts = Date().time
            val url = it.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("apikey", BuildConfig.PUBLIC_KEY)
                    .addQueryParameter("ts", ts.toString())
                    .addQueryParameter("hash", "$ts${BuildConfig.PRIVATE_KEY}${BuildConfig.PUBLIC_KEY}".md5())
                    .build()

            val request = it.request().newBuilder().url(url).build()

            it.proceed(request)
        }
    }

    @Provides
    @Singleton
    fun providesHttpClient(interceptor: Interceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .apply {
                    if (BuildConfig.DEBUG) {
                        addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    }
                }

                .build()
    }

    @Provides
    @Singleton
    fun providesRetrofit(httpClient: OkHttpClient): Retrofit {

        val nullOnEmptyConverterFactory = object : Converter.Factory() {
            fun converterFactory() = this
            override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>, retrofit: Retrofit) = object : Converter<ResponseBody, Any?> {
                val nextResponseBodyConverter = retrofit.nextResponseBodyConverter<Any?>(converterFactory(), type, annotations)
                override fun convert(value: ResponseBody) = if (value.contentLength() != 0L) nextResponseBodyConverter.convert(value) else null
            }
        }

        return Retrofit.Builder()
                .addConverterFactory(nullOnEmptyConverterFactory)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(httpClient)
                .baseUrl(BuildConfig.ENDPOINT)
                .build()
    }
}