package com.example.gallerytask.data.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.gallerytask.data.models.PhotoDbEntity

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photos")
    fun getAllPhotos():List<PhotoDbEntity>

    @Insert
    fun insertEntity(vararg photo : PhotoDbEntity)

    @Delete
    fun delete(photo : PhotoDbEntity)
}