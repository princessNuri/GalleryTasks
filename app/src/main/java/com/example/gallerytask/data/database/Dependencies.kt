package com.example.gallerytask.data.database

import android.content.Context
import androidx.room.Room

object Dependencies {

    private lateinit var applicationContext : Context
    private const val DB_NAME = "photos"

    fun init(context: Context){
        applicationContext=context
    }

    val dataBase = Room.databaseBuilder(
        applicationContext,
        AppDataBase::class.java,
        DB_NAME
    ).build()
}