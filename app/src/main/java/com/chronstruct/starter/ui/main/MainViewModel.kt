package com.chronstruct.starter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.chronstruct.starter.Event
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainViewModel @Inject constructor() : ViewModel() {
    private val _navigateToSettings = MutableLiveData<Event<Boolean>>()

    val navigateToSettings: LiveData<Event<Boolean>>
        get() = _navigateToSettings

    fun onClickSettingsButton() {
        _navigateToSettings.value = Event(true)
    }
}
