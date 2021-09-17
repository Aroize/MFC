package ru.aroize.mfc.presentation.entries

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.github.terrakok.cicerone.Router
import ru.aroize.mfc.MfcApp
import ru.aroize.mfc.R
import ru.aroize.mfc.presentation.core.MfcFragment
import ru.aroize.mfc.vm.EntriesViewModel
import javax.inject.Inject

class EntriesFragment: MfcFragment() {

    private val viewModel: EntriesViewModel by viewModels()

    @Inject
    override lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MfcApp.appComponent.let { component ->
            component.inject(this)
            component.inject(viewModel)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_entries, container, false)
    }
}