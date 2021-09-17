package ru.aroize.mfc.navigation

import android.content.Intent
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import ru.aroize.mfc.presentation.core.MainActivity
import ru.aroize.mfc.presentation.entries.EntriesFragment

@Suppress("unused")
object Screens {
    fun main() = ActivityScreen {
        Intent(it, MainActivity::class.java)
    }

    fun entries() = FragmentScreen {
        EntriesFragment()
    }
}