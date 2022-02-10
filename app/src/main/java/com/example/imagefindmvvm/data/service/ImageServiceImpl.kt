package com.example.imagefindmvvm.data.service

import com.example.imagefindmvvm.data.models.ImageListNet
import com.example.imagefindmvvm.data.network.ImageListNetwork
import com.example.imagefindmvvm.domain.service.ImageService
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ImageServiceImpl @Inject constructor(private val imageListNetwork: ImageListNetwork) :
    ImageService {
    override fun get(name: String): Single<ImageListNet> {
        return imageListNetwork.getImageList(name)
    }
}