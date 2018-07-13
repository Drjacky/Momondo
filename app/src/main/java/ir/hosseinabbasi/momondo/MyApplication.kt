package ir.hosseinabbasi.momondo

import android.content.Context
import android.support.multidex.MultiDexApplication
import io.realm.Realm
import io.realm.RealmConfiguration
import ir.hosseinabbasi.momondo.di.component.ApplicationComponent
import ir.hosseinabbasi.momondo.di.component.DaggerApplicationComponent
import ir.hosseinabbasi.momondo.di.module.ApplicationModule

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class MyApplication : MultiDexApplication() {
    var applicationComponent: ApplicationComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()
        initComponents()
        setUpRealm()
    }

    private fun initComponents() {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent!!.inject(this)
    }

    private fun setUpRealm() {
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(realmConfiguration)
    }

    companion object {
        operator fun get(context: Context): MyApplication {
            return context.applicationContext as MyApplication
        }
    }
}