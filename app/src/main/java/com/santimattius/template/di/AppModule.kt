package com.santimattius.template.di

import android.app.Application
import com.santimattius.template.core.data.service
import com.santimattius.template.data.datasources.LocalDataSource
import com.santimattius.template.data.datasources.RemoteDataSource
import com.santimattius.template.data.datasources.implementation.RoomDataSource
import com.santimattius.template.data.datasources.implementation.ServiceDataSource
import com.santimattius.template.data.datasources.implementation.client.PicSumClient
import com.santimattius.template.data.datasources.implementation.client.PicSumService
import com.santimattius.template.data.datasources.implementation.database.PicSumDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    @Named("baseUrl")
    fun provideBaseUrl(): String = "https://pictures.getsandbox.com:443"

    @Provides
    @Singleton
    fun provideDataBase(application: Application): PicSumDataBase =
        PicSumDataBase.create(application)

    @Provides
    fun provideService(@Named("baseUrl") baseUrl: String): PicSumService = service(baseUrl)

    @Provides
    fun provideClient(service: PicSumService): PicSumClient = PicSumClient(service)

    @Provides
    fun provideLocalDataSource(db: PicSumDataBase): LocalDataSource =
        RoomDataSource(db.picSumDao(), Dispatchers.IO)

    @Provides
    fun provideRemoteDataSource(client: PicSumClient): RemoteDataSource = ServiceDataSource(client)
}