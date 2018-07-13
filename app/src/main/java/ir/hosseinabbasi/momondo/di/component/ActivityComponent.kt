package ir.hosseinabbasi.momondo.di.component

import dagger.Component
import ir.hosseinabbasi.momondo.di.module.ActivityModule
import ir.hosseinabbasi.momondo.di.qualifiers.PerActivity
import ir.hosseinabbasi.momondo.ui.base.BaseActivity
import ir.hosseinabbasi.momondo.ui.flightlist.FlightListView
import ir.hosseinabbasi.momondo.ui.main.MainActivity

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@PerActivity
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: BaseActivity)
    fun inject(activity: MainActivity)
    fun inject(fragment: FlightListView)
}