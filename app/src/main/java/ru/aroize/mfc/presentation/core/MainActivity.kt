package ru.aroize.mfc.presentation.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Replace
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.aroize.mfc.MfcApp
import ru.aroize.mfc.R
import ru.aroize.mfc.navigation.BackListener
import ru.aroize.mfc.navigation.Screens
import javax.inject.Inject

class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.fragment_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MfcApp.appComponent.inject(this)

        if (savedInstanceState == null) {
            navigator.applyCommands(
                arrayOf(Replace(Screens.entries()))
            )
        }
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (fragment as? BackListener != null) {
            fragment.onBackPressed()
        } else {
            super.onBackPressed()
        }
    }
}