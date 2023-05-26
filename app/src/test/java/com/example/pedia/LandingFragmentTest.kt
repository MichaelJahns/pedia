package com.example.pedia

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class LandingFragmentTest {


    @Test
    fun navigateToRecycler() {
        val mockNavController = mock(NavController::class.java)
        val landingScenario = launchFragmentInContainer<LandingFragment>()
        landingScenario.onFragment { fragment ->
            Navigation.setViewNavController(fragment.requireView(), mockNavController)
        }
        onView(ViewMatchers.withId(R.id.button)).performClick(ViewActions.click())
        verify(mockNavController).navigate(R.id.recyclerFragment)
    }
}