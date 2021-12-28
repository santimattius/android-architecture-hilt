package com.santimattius.template.di

import com.santimattius.template.domain.repositories.PicturesRepository
import com.santimattius.template.domain.usecases.GetPictures
import com.santimattius.template.ui.viewmodels.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
class PresentationModule {

    @Provides
    @ViewModelScoped
    fun provideGetPictures(repository: PicturesRepository) = GetPictures(repository)
}