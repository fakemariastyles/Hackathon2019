package com.mmb.hackathon2019.remote.api

import com.mmb.hackathon2019.remote.dto.ResultDto
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path


interface NetworkManager {
    @GET("{serial}")
    fun getBalance(@Path(encoded = true, value = "serial") serial: String): Single<ResultDto>

    companion object {
        const val BASE_URL = "http://31.24.236.154:8092/ESB.Api.ETCard.Ver1/api/etcard/"
    }
}