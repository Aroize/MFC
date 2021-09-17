package ru.aroize.mfc.presentation.core

import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import ru.aroize.mfc.navigation.BackListener

abstract class MfcFragment: Fragment(), BackListener {
    abstract var router: Router

    override fun onBackPressed() = router.exit()
}