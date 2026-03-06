package com.ext.android_image_caching_manager



import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.File
import java.io.FileOutputStream

class DiskCache(context: Context) {

    private val cacheDir = File(context.cacheDir, "image_cache")

    init {
        if (!cacheDir.exists()) {
            cacheDir.mkdirs()
        }
    }

    fun get(url: String): Bitmap? {

        val file = File(cacheDir, url.hashCode().toString())

        if (!file.exists()) return null

        return BitmapFactory.decodeFile(file.absolutePath)
    }

    fun put(url: String, bitmap: Bitmap) {

        val file = File(cacheDir, url.hashCode().toString())

        val output = FileOutputStream(file)

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, output)

        output.flush()
        output.close()
    }
}