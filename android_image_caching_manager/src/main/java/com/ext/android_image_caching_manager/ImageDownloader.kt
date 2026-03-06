package com.ext.android_image_caching_manager


import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.net.URL

object ImageDownloader {

    fun download(url: String): Bitmap? {

        return try {

            val connection = URL(url).openStream()

            BitmapFactory.decodeStream(connection)

        } catch (e: Exception) {
            null
        }
    }
}