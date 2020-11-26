package com.abc.swapiclient.di

import com.abc.swapiclient.presenter.search.SearchViewModel_AssistedFactory_Factory.create
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofitInstance() : Retrofit {
        return Retrofit.Builder().baseUrl("https://swapi.dev/api")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    }
}