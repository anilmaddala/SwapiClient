package com.abc.swapiclient.di

import com.abc.swapiclient.data.repository.RepositoryImpl
import com.abc.swapiclient.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
interface RepoModule {
    @Binds
    fun getRepository(repository: RepositoryImpl): Repository
}