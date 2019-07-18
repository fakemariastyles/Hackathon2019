package com.mmb.hackathon2019.data.repository

import com.mmb.hackathon2019.data.entity.ResultEntity
import com.mmb.hackathon2019.data.toResultEntity
import com.mmb.hackathon2019.remote.datasource.HackathonRemoteDataSource
import io.reactivex.Single
import javax.inject.Inject

class HackathonRepository @Inject constructor(private val hackathonRemoteDataSource: HackathonRemoteDataSource){
    fun getResult(serial:String):Single<ResultEntity?>{
        return hackathonRemoteDataSource.getBalance(serial).map {
            it.toResultEntity()
        }
    }
}