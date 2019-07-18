package com.mmb.hackathon2019.remote.datasource

import com.mmb.hackathon2019.remote.api.NetworkManager
import com.mmb.hackathon2019.remote.dto.ResultDto
import io.reactivex.Single
import javax.inject.Inject

class HackathonRemoteDataSource @Inject constructor(private val networkManager: NetworkManager) {
    fun getBalance(serial: String): Single<ResultDto> {
        return networkManager.getBalance(serial)
    }
}