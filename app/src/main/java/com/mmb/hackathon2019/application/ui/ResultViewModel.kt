package com.mmb.hackathon2019.application.ui

import androidx.lifecycle.ViewModel
import com.mmb.hackathon2019.data.repository.HackathonRepository
import javax.inject.Inject

class ResultViewModel @Inject constructor(private val hackathonRepository: HackathonRepository) : ViewModel(){

}