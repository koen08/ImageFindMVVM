package com.example.imagefindmvvm.app.di

import com.example.imagefindmvvm.app.ui.MainViewModel
import com.example.imagefindmvvm.app.ui.ViewModelFactory
import com.example.imagefindmvvm.data.api.ImageApi
import com.example.imagefindmvvm.data.network.ImageListNetwork
import com.example.imagefindmvvm.data.network.ImageListNetworkImpl
import com.example.imagefindmvvm.data.service.ImageServiceImpl
import com.example.imagefindmvvm.domain.service.ImageService
import com.example.imagefindmvvm.domain.usecase.GetImageByName
import dagger.Module
import dagger.Provides

@Module
class ImageListModule {
    @Provides
    fun provideImageListNetwork(imageApi: ImageApi): ImageListNetwork =
        ImageListNetworkImpl(imageApi)

    @Provides
    fun provideImageService(imageListNetwork: ImageListNetwork): ImageService {
        return ImageServiceImpl(imageListNetwork)
    }
}