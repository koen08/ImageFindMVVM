package com.example.imagefindmvvm.app.di

import com.example.imagefindmvvm.app.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [ImageListModule::class, RetrofitModule::class])
@Singleton
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}