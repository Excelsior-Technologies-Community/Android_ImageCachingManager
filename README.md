# **Android Image Caching Manager**


---
Android Image Caching Manager is a lightweight library that downloads images from the internet and efficiently caches them using Memory Cache (LruCache) and Disk Cache. This helps reduce network calls and improves image loading performance.

---

## ✨ **Features**

- Memory caching using LruCache

- Disk caching using Local Storage

- Background image downloading using Kotlin Coroutines

- Automatic caching after download

- Easy to integrate

- Reduces network usage

- Improves app performance



  ---

# **Preview**
---
<p align="center">
  <img src="https://github.com/S13reya/Android_ImageCachingManager/blob/stages/app/src/main/assets/demovideo.png" height="320"/>




</p>




## ⚡ **Installation**

**Step 1:** Add JitPack repository to your root build.gradle:

```gradle
maven { url = uri("https://jitpack.io") }
```

**Step 2:** Add the dependency in your app `build.gradle` (example if hosted on JitPack):  

```gradle
dependencies {
	        implementation 'com.github.Excelsior-Technologies-Community:Android_AppVersionChecker:1.0.1'

}
```

## ⚡ **Permissions**

```
<uses-permission android:name="android.permission.INTERNET"/>

```

## ⚡ **Xml**
```
<?xml version="1.0" encoding="utf-8"?>

<FrameLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="300dp"
        android:layout_height="200dp"
        android:scaleType="centerCrop"/>

</FrameLayout>
```


## ⚡ **MainActivity**
```
package com.ext.android_imagecachingmanager

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.ext.android_image_caching_manager.ImageCacheManager

class MainActivity : AppCompatActivity() {

    lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)

        ImageCacheManager.init(this)

        ImageCacheManager.load(
            "https://thumbs.dreamstime.com/b/beautiful-rain-forest-ang-ka-nature-trail-doi-inthanon-national-park-thailand-36703721.jpg",
            imageView
        )
    }
}

```


## **📄 License**

**MIT License**  
```
Copyright (c) 2025 Excelsior Technologies

Permission is hereby granted, free of charge, to any person obtaining a copy  
of this software and associated documentation files (the "Software"), to deal  
in the Software without restriction, including without limitation the rights  
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell  
copies of the Software, and to permit persons to whom the Software is  
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all  
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED **"AS IS"**, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR  
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,  
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
```



  
