@file:Suppress("unused")

package ru.aroize.mfc.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.aroize.mfc.network.api.MfcService
import ru.aroize.mfc.network.impl.retrofit.MfcRetrofitService
import rx.schedulers.Schedulers
import javax.inject.Singleton

@Module
class NetworkModule {

    private companion object {
        const val API_URL = "https://localhost"
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideConverter(gson: Gson): Converter.Factory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideCallAdapter(): CallAdapter.Factory {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        converter: Converter.Factory,
        callAdapter: CallAdapter.Factory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(converter)
            .addCallAdapterFactory(callAdapter)
            .build()
    }

    @Provides
    @Singleton
    fun provideMfcService(retrofit: Retrofit): MfcService {
        return retrofit.create(MfcRetrofitService::class.java)
    }
}