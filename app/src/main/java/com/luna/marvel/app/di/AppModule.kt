package com.luna.marvel.app.di

import com.luna.marvel.app.data.remote.services.CharactersService
import com.luna.marvel.app.data.remote.services.ComicsService
import com.luna.marvel.app.data.remote.services.CreatorsService
import com.luna.marvel.app.data.remote.services.EventsService
import com.luna.marvel.app.data.remote.services.SeriesService
import com.luna.marvel.app.data.remote.services.StoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    init {
        System.loadLibrary("keys")
    }

    private external fun getBaseUrl(): String
    private external fun getPublicKey(): String
    private external fun getPrivateKey(): String

    @Provides
    @PublicKey
    fun providePublicKey(): String = getPublicKey()

    @Provides
    @PrivateKey
    fun providePrivateKey(): String = getPrivateKey()

    @Singleton
    @Provides
    fun provideRetrofitClient(): Retrofit = Retrofit.Builder()
        .baseUrl(getBaseUrl())
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