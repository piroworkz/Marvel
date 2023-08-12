package com.luna.marvel.app.data.remote.utils

import com.luna.marvel.app.di.PrivateKey
import com.luna.marvel.app.di.PublicKey
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import javax.inject.Inject

class MarvelInterceptor @Inject constructor(
    @PublicKey private val publicKey: String,
    @PrivateKey private val privateKey: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        return try {
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter(API_KEY, publicKey)
                .addQueryParameter(TS, System.currentTimeMillis().toString())
                .addQueryParameter(HASH, getHash())
                .build()
            val request = original.newBuilder()
                .url(url)
                .build()
            chain.proceed(request)
        } catch (e: Exception) {
            println(e.stackTrace)
            chain.proceed(original)
        }
    }

    private fun getHash(): String {
        return MessageDigest.getInstance("MD5")
            .digest("${System.currentTimeMillis()}$privateKey$publicKey".toByteArray()).apply {
                BigInteger(1, this).toString(16).padStart(32, '0')
            }.toString()
    }

    companion object {
        private const val API_KEY = "apikey"
        private const val TS = "ts"
        private const val HASH = "hash"
    }

}