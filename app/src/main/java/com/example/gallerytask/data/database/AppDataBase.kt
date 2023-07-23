package com.example.gallerytask.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.gallerytask.data.models.PhotoDbEntity

@Database(version = 1, entities = [PhotoDbEntity::class])
abstract class AppDataBase : RoomDatabase() {

    abstract fun photosDao (): PhotosDao
}