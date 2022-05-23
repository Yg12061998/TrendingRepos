package com.yogigupta1206.trendingrepos.ui.main

import androidx.lifecycle.ViewModel
import com.yogigupta1206.trendingrepos.repositories.ReposRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val reposRepository: ReposRepositories
) : ViewModel() {


}