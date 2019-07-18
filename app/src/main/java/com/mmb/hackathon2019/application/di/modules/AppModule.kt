package com.mmb.hackathon2019.application.di.modules

import android.content.Context
import com.mmb.hackathon2019.application.HackathonApp
import dagger.Module
import dagger.Provides

@Module
class AppModule (var app: HackathonApp){
    @Provides
    fun provideContext():Context{
        return app.applicationContext
    }
}