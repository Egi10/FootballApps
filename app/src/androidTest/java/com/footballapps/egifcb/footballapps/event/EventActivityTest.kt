package com.footballapps.egifcb.footballapps.event

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.Espresso.pressBack
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.support.v7.widget.RecyclerView
import com.footballapps.egifcb.footballapps.R
import com.footballapps.egifcb.footballapps.R.id.*
import com.footballapps.egifcb.footballapps.home.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class EventActivityTest {
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun testRecyclerViewBehaviour() {
        Thread.sleep(2000)

        onView(withId(list_next_event))
                .check(matches(isDisplayed()))
        onView(withId(list_next_event)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(10))
        onView(withId(list_next_event)).perform(
                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(10, click()))
    }

    @Test
    fun testAppBehaviour() {
        onView(withId(navigation))
                .check(matches(isDisplayed()))

        onView(withId(navigation_event))
                .check(matches(isDisplayed()))
        onView(withId(navigation_event)).perform(click())

        onView(withId(tab_layout))
                .check(matches(isDisplayed()))

        onView(withText("NEXT"))
                .check(matches(isDisplayed()))
        onView(withText("NEXT")).perform(click())

        onView(withId(swipe_next_event))
                .check(matches(isDisplayed()))

        Thread.sleep(2000)

        onView(withText("Liverpool"))
                .check(matches(isDisplayed()))
        onView(withText("Liverpool")).perform(click())

        onView(withId(faforite))
                .check(matches(isDisplayed()))
        onView(withId(faforite)).perform(click())

        onView(withText(R.string.savefavorite))
                .check(matches(isDisplayed()))

        pressBack()

        onView(withId(navigation))
                .check(matches(isDisplayed()))

        onView(withId(navigation_favorite))
                .check(matches(isDisplayed()))
        onView(withId(navigation_favorite)).perform(click())

        Thread.sleep(2000)
    }
}
