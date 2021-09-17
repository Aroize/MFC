package ru.aroize.mfc.di

import dagger.Component
import ru.aroize.mfc.presentation.core.MainActivity
import ru.aroize.mfc.presentation.entries.EntriesFragment
import ru.aroize.mfc.vm.EntriesViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, NavigationModule::class])
interface AppComponent {
    fun inject(activity: MainActivity)

    fun inject(fragment: EntriesFragment)
    fun inject(viewModel: EntriesViewModel)
}