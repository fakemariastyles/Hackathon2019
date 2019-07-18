package com.mmb.hackathon2019.application.ui.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mmb.hackathon2019.data.repository.HackathonRepository
import javax.inject.Inject

class ViewModelFactory @Inject constructor(private val hackathonRepository: HackathonRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       return ResultViewModel(hackathonRepository) as T
    }

}