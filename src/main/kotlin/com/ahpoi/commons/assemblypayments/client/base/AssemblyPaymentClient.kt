package com.ahpoi.commons.assemblypayments.client.base

import com.ahpoi.commons.assemblypayments.api.AssemblyPaymentsApi
import com.ahpoi.commons.assemblypayments.client.CardAccountClient
import com.ahpoi.commons.assemblypayments.client.ItemClient
import com.ahpoi.commons.assemblypayments.client.TokenAuthClient
import com.ahpoi.commons.assemblypayments.client.UserClient
import com.ahpoi.commons.assemblypayments.util.encodeString
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import java.util.concurrent.TimeUnit

enum class LogLevel {
    NONE, BASIC, HEADERS, FULL
}

data class ClientConfig(val rootUrl: String,
                        val username: String,
                        val password: String,
                        val connectTimeout: Long = 60L,
                        val readTimeout: Long = 60L,
                        val logLevel: LogLevel = LogLevel.BASIC) {
    fun basicAuth() = "Basic" + " " + encodeString(username + ":" + password)
}

class AssemblyPaymentsClient(private val config: ClientConfig) {

    private val logging = HttpLoggingInterceptor().apply {
        this.level = when {
            config.logLevel == LogLevel.NONE -> HttpLoggingInterceptor.Level.NONE
            config.logLevel == LogLevel.BASIC -> HttpLoggingInterceptor.Level.BASIC
            config.logLevel == LogLevel.HEADERS -> HttpLoggingInterceptor.Level.HEADERS
            config.logLevel == LogLevel.FULL -> HttpLoggingInterceptor.Level.BODY
            else -> HttpLoggingInterceptor.Level.BASIC
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .readTimeout(config.readTimeout, TimeUnit.SECONDS)
            .connectTimeout(config.connectTimeout, TimeUnit.SECONDS).build()

    private val retrofit = Retrofit.Builder()
            .baseUrl(config.rootUrl)
            .client(okHttpClient)
            .addConverterFactory(JacksonConverterFactory
                    .create(jacksonObjectMapper()
                            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                            .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                            .registerModule(KotlinModule())))
            .build()

    private val api = retrofit.create(AssemblyPaymentsApi::class.java)

    fun userClient() = UserClient(config, api)

    fun cardAccountClient() = CardAccountClient(config, api)

    fun itemClient() = ItemClient(config, api)

    fun tokenAuthClient() = TokenAuthClient(config, api)

}

