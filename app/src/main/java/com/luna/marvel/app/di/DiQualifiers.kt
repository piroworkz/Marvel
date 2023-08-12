package com.luna.marvel.app.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BaseUrl

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PublicKey

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PrivateKey
