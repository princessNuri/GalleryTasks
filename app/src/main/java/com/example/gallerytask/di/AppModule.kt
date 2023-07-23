package com.example.gallerytask.di

import android.content.Context
import com.example.gallerytask.data.database.AppDataBase
import com.example.gallerytask.data.database.Dependencies
import com.example.gallerytask.data.database.PhotosDao
import toothpick.config.Module

class AppModule(private val context: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(context)

        val appDataBase = Dependencies.dataBase
        bind(AppDataBase::class.java).toInstance(appDataBase)
        bind(PhotosDao::class.java).toInstance(appDataBase.photosDao())
    }
}