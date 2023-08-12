package com.luna.marvel.app.di

import com.luna.marvel.app.data.remote.datasources.RemoteCharactersDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteComicsDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteCreatorsDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteEventsDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteSeriesDataSource
import com.luna.marvel.app.data.remote.datasources.RemoteStoriesDataSource
import com.luna.data.sources.CharactersDataSource
import com.luna.data.sources.ComicsDataSource
import com.luna.data.sources.CreatorsDataSource
import com.luna.data.sources.EventsDataSource
import com.luna.data.sources.SeriesDataSource
import com.luna.data.sources.StoriesDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindsCharacterDataSource(remoteCharactersDataSource: RemoteCharactersDataSource): CharactersDataSource

    @Binds
    abstract fun bindsComicsDataSource(remoteComicsDataSource: RemoteComicsDataSource): ComicsDataSource

    @Binds
    abstract fun bindsCreatorsDataSource(remoteCreatorsDataSource: RemoteCreatorsDataSource): CreatorsDataSource

    @Binds
    abstract fun bindsEventsDataSource(remoteEventsDataSource: RemoteEventsDataSource): EventsDataSource

    @Binds
    abstract fun bindsSeriesDataSource(remoteSeriesDataSource: RemoteSeriesDataSource): SeriesDataSource

    @Binds
    abstract fun bindsStoriesDataSource(remoteStoriesDataSource: RemoteStoriesDataSource): StoriesDataSource

}