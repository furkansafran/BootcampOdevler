package com.furkansafran.yemekuygulamasi.di

import com.furkansafran.yemekuygulamasi.data.model.datasource.YemeklerDataSource
import com.furkansafran.yemekuygulamasi.data.model.repository.YemeklerRepository
import com.furkansafran.yemekuygulamasi.retrofit.ApiUtils
import com.furkansafran.yemekuygulamasi.retrofit.YemeklerDaoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemeklerRepository(yemeklerDataSource: YemeklerDataSource): YemeklerRepository {
        return YemeklerRepository(yemeklerDataSource)
    }
    @Provides
    @Singleton
    fun provideYemeklerDataSource(yemeklerDaoInterface: YemeklerDaoInterface): YemeklerDataSource {
        return YemeklerDataSource(yemeklerDaoInterface)
    }
    @Provides
    @Singleton
    fun provideYemeklerDaoInterface(): YemeklerDaoInterface {
        return ApiUtils.getYemeklerDaoInterface()
    }
}