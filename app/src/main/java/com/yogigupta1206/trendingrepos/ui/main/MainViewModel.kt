package com.yogigupta1206.trendingrepos.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yogigupta1206.trendingrepos.data.model.repos.Repos
import com.yogigupta1206.trendingrepos.repositories.ReposRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject


@HiltViewModel
class MainViewModel@Inject constructor(
    private val repository: ReposRepositories
) : ViewModel() {

    sealed class UiState{
        object Loading: UiState()
        object LoadingFinish: UiState()
        object ErrorState: UiState()
    }

    val uiState: LiveData<UiState> get() = _uiState
    val repos: LiveData<MutableList<Repos>> get() = _repos

    private var _uiState = MutableLiveData<UiState>()
    private var _repos = MutableLiveData<MutableList<Repos>>()

    private var reposData = arrayListOf<Repos>()

    fun init(){
        _uiState.value = UiState.Loading
        if(reposData.isEmpty()){
            viewModelScope.launch {
                val data = withContext(Dispatchers.IO){ repository.getReposData() }
                _uiState.value = UiState.LoadingFinish
                if(data.isNotEmpty()){
                    data.let{
                        reposData.clear()
                        reposData.addAll(it)
                        _repos.value = it
                    }
                }else{
                    _uiState.postValue(UiState.ErrorState)
                }
            }

        }else{
            _uiState.postValue(UiState.LoadingFinish)
            _repos.value = reposData
        }
    }


    fun filter(text: String): MutableList<Repos> {
        val filteredList = mutableListOf<Repos>()

        if(text.isBlank())
            return reposData

        for (item in reposData) {
            if (item.name.lowercase(Locale.getDefault()).contains(text.lowercase(Locale.getDefault()))) {
                filteredList.add(item)
            }
        }
        return filteredList
    }

}