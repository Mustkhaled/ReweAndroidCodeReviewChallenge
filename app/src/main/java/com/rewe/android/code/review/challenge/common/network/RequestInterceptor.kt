package com.rewe.android.code.review.challenge.common.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

const val accessToken = "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"

class RequestInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader("Authorization", accessToken).build()
        return chain.proceed(request)
    }
}