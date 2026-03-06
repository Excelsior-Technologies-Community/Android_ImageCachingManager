package com.ext.android_image_caching_manager



import android.graphics.Bitmap
import android.util.LruCache

class MemoryCache {

    private val cache: LruCache<String, Bitmap>

    init {

        val maxMemory = (Runtime.getRuntime().maxMemory() / 1024).toInt()
        val cacheSize = maxMemory / 8

        cache = object : LruCache<String, Bitmap>(cacheSize) {

            override fun sizeOf(key: String, bitmap: Bitmap): Int {
                return bitmap.byteCount / 1024
            }
        }
    }

    fun get(key: String): Bitmap? {
        return cache.get(key)
    }

    fun put(key: String, bitmap: Bitmap) {
        cache.put(key, bitmap)
    }
}