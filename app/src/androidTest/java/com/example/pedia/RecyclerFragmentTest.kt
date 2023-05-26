package com.example.pedia

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import junit.framework.TestCase.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class RecyclerFragmentTest {

    @Test
    fun navigateToLanding() {
        val navController = TestNavHostController(
            ApplicationProvider.getApplicationContext()
        )
        val recyclerScenario = launchFragmentInContainer<RecyclerFragment>()
        recyclerScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            navController.setCurrentDestination(R.id.recyclerFragment)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }
        onView(ViewMatchers.withId(R.id.button)).perform(ViewActions.click())
        TestCase.assertEquals(navController.currentDestination?.id, R.id.landingFragment)
    }
}