package com.furkansafran.todoapp.di

import android.content.Context
import androidx.room.Room
import com.furkansafran.todoapp.data.entity.datasource.ToDosDataSource
import com.furkansafran.todoapp.data.entity.repository.ToDosRepository
import com.furkansafran.todoapp.room.ToDosDao
import com.furkansafran.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providesToDosRepository(toDosDataSource: ToDosDataSource) : ToDosRepository{
        return ToDosRepository(toDosDataSource)
    }
    @Provides
    @Singleton
    fun providesToDosDataSource(toDosDao: ToDosDao) : ToDosDataSource{
        return ToDosDataSource(toDosDao)
    }
    @Provides
    @Singleton
    fun providesToDosDao(@ApplicationContext context: Context) : ToDosDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"toDos.sqlite").createFromAsset("toDos.sqlite").build()
        return vt.getToDosDao()


    }

}