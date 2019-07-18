package com.mmb.hackathon2019.remote.api

import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.URL
import android.R.attr.password
import java.util.*
import java.util.Base64.getEncoder


class Network {
    fun get(url: String): String {
        return URL(url)
        .openStream()
            .bufferedReader()
            .use {
                it.readText()
            }

    }

    fun post(url: String, body: String): String {
        return URL(url)
            .openConnection()
            .let {
                it as HttpURLConnection
            }.apply {
                setRequestProperty("Content-Type", "application/json; charset=utf-8")
                requestMethod = "POST"

                doOutput = true
                val outputWriter = OutputStreamWriter(outputStream)
                outputWriter.write(body)
                outputWriter.flush()
            }.let {
                if (it.responseCode == 200) it.inputStream else it.errorStream
            }.let { streamToRead ->
                BufferedReader(InputStreamReader(streamToRead)).use {
                    val response = StringBuffer()

                    var inputLine = it.readLine()
                    while (inputLine != null) {
                        response.append(inputLine)
                        inputLine = it.readLine()
                    }
                    it.close()
                    response.toString()
                }
            }
    }
}

fun main() {
    val networkManager = Network()
    val rawData = networkManager.get("http://31.24.236.154:8092/ESB.Api.ETCard.Ver1/api/etcard/25426508")
    println(rawData)
}