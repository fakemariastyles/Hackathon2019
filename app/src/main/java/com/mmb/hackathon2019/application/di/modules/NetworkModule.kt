package com.mmb.hackathon2019.application.di.modules

import com.mmb.hackathon2019.R
import com.mmb.hackathon2019.remote.api.NetworkManager
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import android.os.AsyncTask.execute
import okhttp3.CipherSuite
import okhttp3.ConnectionSpec
import okhttp3.TlsVersion
import org.apache.http.conn.ssl.X509HostnameVerifier
import org.apache.http.conn.ssl.SSLSocketFactory
import org.apache.http.params.HttpParams
import java.util.*
import javax.net.ssl.HttpsURLConnection


@Module
class NetworkModule{
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
        return  Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(NetworkManager.BASE_URL)
            .build()
    }

    @Provides
    fun provideOkHttpClient():OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .header("Authorization", com.mmb.hackathon2019.R.string.access_token.toString())

                val newRequest = requestBuilder.build()
                chain.proceed(newRequest)
            }
            .build()



    }

    @Provides
    @Singleton
    fun provideNetworkManager(retrofit: Retrofit):NetworkManager{
        return retrofit.create(NetworkManager::class.java)
    }


}