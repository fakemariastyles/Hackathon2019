package com.mmb.hackathon2019.application

import android.app.Application
import com.mmb.hackathon2019.application.di.AppComponent
import com.mmb.hackathon2019.application.di.DaggerAppComponent
import com.mmb.hackathon2019.application.di.modules.AppModule

class HackathonApp : Application(){
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .appModule(AppModule(this)).build()
    }

    companion object{
        lateinit var component : AppComponent
    }
}