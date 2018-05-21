package com.chronstruct.starter.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainViewModelTest {

    // Execute tasks synchronously (for LiveData)
    @Rule
    @JvmField
    val rule = InstantTaskExecutorRule()

    private lateinit var vm: MainViewModel

    @Before
    fun setup() {
        vm = MainViewModel()
    }

    @Test
    fun `Settings Button fires event to Navigate To Settings`() {
        // arrange
//        val observer = mock(Observer::class.java)
//        vm.navigateToSettings.observeForever(observer)

        // act
        vm.onClickSettingsButton()

        // assert
//        verify(observer).onChanged(true)
        assert(vm.navigateToSettings.value?.getContentIfNotHandled() == true)
    }
}