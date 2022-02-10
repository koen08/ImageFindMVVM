package com.example.imagefindmvvm.data.network

import com.example.imagefindmvvm.data.api.ImageApi
import com.example.imagefindmvvm.data.models.ImageListNet
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ImageListNetworkImpl @Inject constructor(val imageApi: ImageApi) : ImageListNetwork {
    override fun getImageList(name: String): Single<ImageListNet> {
        return imageApi.getImageList("25581308-ddc9b39954bc82683e4afb26b", name, "horizontal")
    }
}