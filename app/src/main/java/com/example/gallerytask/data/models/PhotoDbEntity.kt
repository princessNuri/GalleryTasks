package com.example.gallerytask.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "photos", indices = [Index("id")])
data class PhotoDbEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "file_path")
    val filePath: String,

    @ColumnInfo(name = "coordinates")
    val coordinates: String,

    @ColumnInfo(name = "directory")
    val directory: String,

    @ColumnInfo(name = "creation_time")
    val creationTime: Int

)
