package com.ext.android_image_caching_manager

import kotlin.text.get



import android.content.Context
import android.widget.ImageView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

object ImageCacheManager {

    private lateinit var memoryCache: MemoryCache
    private lateinit var diskCache: DiskCache

    fun init(context: Context) {
        memoryCache = MemoryCache()
        diskCache = DiskCache(context)
    }

    fun load(url: String, imageView: ImageView) {

        val cachedBitmap = memoryCache.get(url)

        if (cachedBitmap != null) {
            imageView.setImageBitmap(cachedBitmap)
            return
        }

        CoroutineScope(Dispatchers.IO).launch {

            val diskBitmap = diskCache.get(url)

            if (diskBitmap != null) {

                memoryCache.put(url, diskBitmap)

                withContext(Dispatchers.Main) {
                    imageView.setImageBitmap(diskBitmap)
                }

                return@launch
            }

            val bitmap = ImageDownloader.download(url)

            bitmap?.let {

                memoryCache.put(url, it)
                diskCache.put(url, it)

                withContext(Dispatchers.Main) {
                    imageView.setImageBitmap(it)
                }
            }
        }
    }
}