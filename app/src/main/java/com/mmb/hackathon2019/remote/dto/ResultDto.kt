package com.mmb.hackathon2019.remote.dto


import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("EtcardId")
    val etcardId: Int?,
    @SerializedName("MessageDetail")
    val messageDetail: Any?,
    @SerializedName("RemainAmount")
    val remainAmount: String?
)