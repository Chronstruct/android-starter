package com.chronstruct.starter.ui.main

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.PreferenceMatchers.withKey
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.chronstruct.starter.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val rule = ActivityTestRule(MainActivity::class.java, true, true)

    @Test
    fun canNavigateToSettings() {
        // given
        val settingsButton = onView(withId(R.id.btn_settings))

        // when
        settingsButton.perform(click())

        // then
        onData(withKey("settings")).check(matches(isDisplayed()))
    }


}