package com.mmb.hackathon2019.application.di

import com.mmb.hackathon2019.application.ui.main.MainActivity
import com.mmb.hackathon2019.application.di.modules.AppModule
import com.mmb.hackathon2019.application.di.modules.NetworkModule
import com.mmb.hackathon2019.application.ui.result.ResultFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, AppModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(resultFragment: ResultFragment)
}