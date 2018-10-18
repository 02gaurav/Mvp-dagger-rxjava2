package com.example.apple.mindsharpner.di.modules

import com.example.apple.mindsharpner.BuildConfig
import com.example.apple.mindsharpner.data.remote.services.QuestionService
import com.example.apple.mindsharpner.di.Qualifier.NormalOkHttpClient
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.Protocol
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetModule {
    companion object {
        const val baseURL = ""
    }

    @Provides
    @Singleton
    fun provideOkHttpBuilder(): OkHttpClient.Builder {
        val protocols = listOf(Protocol.HTTP_1_1, Protocol.HTTP_2)
        val okHttpClientBuilder = OkHttpClient.Builder()
                .protocols(protocols)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            okHttpClientBuilder.addInterceptor(loggingInterceptor)
        }
        // TODO Add data usage monitor here
        return okHttpClientBuilder
    }

    @Provides
    @Singleton
    @NormalOkHttpClient
    fun provideNormalOkhttp(okHttpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        return okHttpClientBuilder
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, @NormalOkHttpClient okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .callFactory(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideLoginService(retrofit: Retrofit) : QuestionService {
        return retrofit.create(QuestionService::class.java)
    }
}