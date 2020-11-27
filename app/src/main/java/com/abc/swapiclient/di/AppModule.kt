package com.abc.swapiclient.di

import android.app.Person
import com.abc.swapiclient.data.network.NetworkDataSource
import com.abc.swapiclient.data.network.vo.People
import com.abc.swapiclient.domain.util.EntityMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
//import com.abc.swapiclient.framework.network.NetworkDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Qualifier
    @Retention(AnnotationRetention.RUNTIME)
    annotation class RemoteDataSource
//
//    @Qualifier
//    @Retention(AnnotationRetention.RUNTIME)
//    annotation class LocalTasksDataSource
//
//    @Singleton
//    @RemoteDataSource
//    @Provides
//    fun provideRemoteDataSource(): NetworkDataSource {
//        return NetworkDataSourceImpl()
//    }

//    @Binds
//    abstract fun bindAnalyticsService(
//        analyticsServiceImpl: NetworkDataSourceImpl
//    ): NetworkDataSource

//    @Singleton
//    @Provides
//    fun provideNetworkMapper(): EntityMapper<People, Person> {
//        return EntityMapper()
//    }

    @Singleton
    @Provides
    fun provideGsonBuilderInstance(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(gson:  Gson): NetworkDataSource {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        return retrofit.create()
    }
}