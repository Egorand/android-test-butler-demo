/*
 * Copyright 2016 Egor Andreevici
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package me.egorand.testbutlerdemo

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withText
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test

class OrientationChangeTest {

    @Rule @JvmField val activityTestRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test fun shouldDisplayMasterFragmentInPortrait() {
        rotateToPortrait()

        onView(withText(R.string.master_message)).check(matches(isDisplayed()))
    }

    @Test fun shouldDisplayMasterAndDetailFragmentsInLandscape() {
        rotateToLandscape()

        onView(withText(R.string.master_message)).check(matches(isDisplayed()))
        onView(withText(R.string.detail_message)).check(matches(isDisplayed()))
    }
}