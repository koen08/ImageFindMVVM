package com.example.imagefindmvvm.domain.service

import com.example.imagefindmvvm.data.models.ImageListNet
import io.reactivex.rxjava3.core.Single

interface ImageService {
    fun get(name: String): Single<ImageListNet>
}