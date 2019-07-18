package com.mmb.hackathon2019.data

import com.mmb.hackathon2019.data.entity.ResultEntity
import com.mmb.hackathon2019.remote.dto.ResultDto

fun ResultDto.toResultEntity() = ResultEntity(
    etCardId = etcardId,
    messageDetail = messageDetail,
    remainAmount = remainAmount
)