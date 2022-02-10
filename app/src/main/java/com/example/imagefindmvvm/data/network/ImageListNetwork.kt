package com.example.imagefindmvvm.data.network

import com.example.imagefindmvvm.data.models.ImageListNet
import io.reactivex.rxjava3.core.Single

interface ImageListNetwork {
    fun getImageList(name: String): Single<ImageListNet>
}