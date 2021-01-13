package com.example.core.di

import android.content.Context
import android.content.SharedPreferences
import com.example.core.domain.network.NetworkService
import com.example.core.domain.repository.Repository
import com.example.core.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
class DataModule {
    @Provides
    @Singleton
    fun provideRepository(networkService : NetworkService, sharedPreferences: SharedPreferences): Repository {
        return Repository(networkService, sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences{
        return context.getSharedPreferences(
            Constants.PreferenceKeys.toString(),
            Context.MODE_PRIVATE
        )
    }
}