package com.mmb.hackathon2019.application.ui

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mmb.hackathon2019.data.entity.ResultEntity
import com.mmb.hackathon2019.data.repository.HackathonRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ResultViewModel @Inject constructor(private val hackathonRepository: HackathonRepository) : ViewModel() {
    private var _result = MutableLiveData<ResultEntity>()
    var result: LiveData<ResultEntity> = _result

    @SuppressLint("CheckResult")
    fun getResult(serial: String) {
        hackathonRepository.getResult(serial)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _result.postValue(it)
            }, {
                println(it)
            })
    }
}