package com.luna.marvel.app.di

import com.luna.marvel.app.data.remote.services.CharactersService
import com.luna.marvel.app.data.remote.services.ComicsService
import com.luna.marvel.app.data.remote.services.CreatorsService
import com.luna.marvel.app.data.remote.services.EventsService
import com.luna.marvel.app.data.remote.services.SeriesService
import com.luna.marvel.app.data.remote.services.StoriesService
import com.luna.marvel.app.data.remote.utils.MarvelInterceptor
import com.luna.marvel.app.di.qualifiers.BaseUrl
import com.luna.marvel.app.di.qualifiers.PrivateKey
import com.luna.marvel.app.di.qualifiers.PublicKey
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [AppModule::class]
)
object TestAppModule {

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String = "http://localhost:8080/v1/public/"

    @Provides
    @PublicKey
    fun providePublicKey(): String = "12345678"

    @Provides
    @PrivateKey
    fun providePrivateKey(): String = "87654321"

    @Singleton
    @Provides
    fun provideOkHttp3Client(
        interceptor: MarvelInterceptor,
    ): OkHttpClient =
        HttpLoggingInterceptor().run {
            level = HttpLoggingInterceptor.Level.BODY
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(this)
                .build()
        }

    @Singleton
    @Provides
    fun provideRetrofitClient(
        @BaseUrl baseUrl: String,
        okHttpClient: OkHttpClient,
    ): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideCharactersService(retrofit: Retrofit): CharactersService =
        retrofit.create(CharactersService::class.java)

    @Singleton
    @Provides
    fun provideComicsService(retrofit: Retrofit): ComicsService =
        retrofit.create(ComicsService::class.java)

    @Singleton
    @Provides
    fun provideCreatorsService(retrofit: Retrofit): CreatorsService =
        retrofit.create(CreatorsService::class.java)

    @Singleton
    @Provides
    fun provideEventsService(retrofit: Retrofit): EventsService =
        retrofit.create(EventsService::class.java)

    @Singleton
    @Provides
    fun provideSeriesService(retrofit: Retrofit): SeriesService =
        retrofit.create(SeriesService::class.java)

    @Singleton
    @Provides
    fun provideStoriesService(retrofit: Retrofit): StoriesService =
        retrofit.create(StoriesService::class.java)
}