package com.mmb.hackathon2019.application.di

import com.mmb.hackathon2019.MainActivity
import com.mmb.hackathon2019.application.di.modules.AppModule
import com.mmb.hackathon2019.application.di.modules.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}