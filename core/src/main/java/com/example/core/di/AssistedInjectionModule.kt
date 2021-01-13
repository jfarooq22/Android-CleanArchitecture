package com.example.core.di

import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.migration.DisableInstallInCheck

@InstallIn(ApplicationComponent::class)
@AssistedModule
@Module
@DisableInstallInCheck
interface AssistedInjectionModule