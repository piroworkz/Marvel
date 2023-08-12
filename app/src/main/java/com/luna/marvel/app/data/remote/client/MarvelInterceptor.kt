package com.luna.marvel.app.data.remote.client

import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest

class MarvelInterceptor(
    private val publicKey: String,
    private val privateKey: String,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalHttpUrl = original.url
        return try {
            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", publicKey)
                .addQueryParameter("ts", System.currentTimeMillis().toString())
                .addQueryParameter("hash", getHash())
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

}