package com.example.daggerhilt

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhilt.network.RecyclerData
import com.example.daggerhilt.data.repository.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val repository: RetroRepository
): ViewModel() {
    lateinit var liveDataList: MutableLiveData<List<RecyclerData>>

    init {
        liveDataList = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<RecyclerData>> {
        return liveDataList
    }

    fun loadListOfData() {
        viewModelScope.launch {
            repository.makeApiCall("ny", liveDataList)
        }
    }
}