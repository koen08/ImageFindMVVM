package com.example.imagefindmvvm.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.imagefindmvvm.R
import com.example.imagefindmvvm.app.App
import com.example.imagefindmvvm.app.ui.adapters.ImageListAdapter
import com.example.imagefindmvvm.domain.models.ImageDao
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    var recyclerView: RecyclerView? = null
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
        recyclerView = findViewById(R.id.recycleView)
        recyclerView?.layoutManager = LinearLayoutManager(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        viewModel.listImageLiveData.observe(this, ::glideImageList)

        viewModel.getImageListByName("android")
    }

    private fun glideImageList(imageList: List<ImageDao>) {
        val adapter = ImageListAdapter(imageList)
        recyclerView?.adapter = adapter
    }

    override fun onDestroy() {
        viewModel.onDestroy()
        super.onDestroy()
    }
}