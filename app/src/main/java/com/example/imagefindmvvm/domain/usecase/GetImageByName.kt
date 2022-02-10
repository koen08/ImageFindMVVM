package com.example.imagefindmvvm.domain.usecase

import com.example.imagefindmvvm.data.models.ImageListNet
import com.example.imagefindmvvm.domain.service.ImageService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GetImageByName @Inject constructor(private val imageService: ImageService) {
    fun get(name: String): Single<ImageListNet> {
        return imageService.get(name)
    }
}