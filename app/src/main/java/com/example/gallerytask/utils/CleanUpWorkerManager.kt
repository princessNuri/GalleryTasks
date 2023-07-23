package com.example.gallerytask.utils

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.gallerytask.data.database.Dependencies
import java.io.File
import java.util.concurrent.TimeUnit

class CleanUpWorkerManager(context: Context, parameters: WorkerParameters) :
    CoroutineWorker(context, parameters) {
    override suspend fun doWork(): Result {
        try {
            val db = Dependencies.dataBase
            val photoDao = db.photosDao()

            val photos = photoDao.getAllPhotos()

            val currentTimeMillis = System.currentTimeMillis()
            val twoHours = TimeUnit.HOURS.toMillis(2)

            for (photo in photos) {
                if (currentTimeMillis - photo.creationTime > twoHours) {
                    deletePhotoFile(photo.filePath)
                    photoDao.delete(photo)
                }
            }
        } catch (ex: Exception) {
            return Result.failure()
        }
        return Result.success()
    }

    private fun deletePhotoFile(filePath: String) {
        val file = File(filePath)
        if (file.exists()) {
            file.delete()
        }
    }

}