package com.mmb.hackathon2019.remote.datasource

import com.mmb.hackathon2019.remote.api.NetworkManager
import com.mmb.hackathon2019.remote.dto.ResultDto
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HackathonRemoteDataSource @Inject constructor(private val networkManager: NetworkManager) {
    fun getBalance(serial: String): Single<ResultDto?> {
        val res = networkManager.getBalance(serial)
        println(serial)
            println("ResultDto")
        return  res
    }
}