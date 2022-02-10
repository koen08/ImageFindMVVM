package com.example.imagefindmvvm.app.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagefindmvvm.data.models.ImageListNet
import com.example.imagefindmvvm.domain.models.ImageDao
import com.example.imagefindmvvm.domain.models.ImageList
import com.example.imagefindmvvm.domain.usecase.GetImageByName
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(private val getImageByName: GetImageByName) : ViewModel() {

    private var dispos: Disposable? = null
    private val listImageMutableLive = MutableLiveData<List<ImageDao>>()
    val listImageLiveData: LiveData<List<ImageDao>> = listImageMutableLive

    fun getImageListByName(name: String) {
        val result = getImageByName.get(name)
        dispos = result.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val imageList = networkDaoToImageDomain(it)
                listImageMutableLive.value = imageList.hits
            }, {
                Log.e("AAA", it.localizedMessage!!)
            })
    }

    private fun networkDaoToImageDomain(imageListNet: ImageListNet): ImageList {
        val imageList = ImageList(ArrayList())
        for (imageDao in imageListNet.hits) {
            imageList.hits.add(ImageDao(imageDao.id, imageDao.url))
        }
        return imageList
    }

    fun onDestroy() {
        dispos?.dispose()
    }
}