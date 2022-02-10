package com.example.imagefindmvvm.app

import android.app.Application
import com.example.imagefindmvvm.app.di.AppComponent
import com.example.imagefindmvvm.app.di.DaggerAppComponent

class App : Application() {
    lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}