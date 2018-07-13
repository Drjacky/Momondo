package ir.hosseinabbasi.momondo.di.component

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Component
import ir.hosseinabbasi.momondo.MyApplication
import ir.hosseinabbasi.momondo.data.db.RealmManager
import ir.hosseinabbasi.momondo.data.network.IApiService
import ir.hosseinabbasi.momondo.di.module.ApplicationModule
import ir.hosseinabbasi.momondo.di.module.DataModule
import ir.hosseinabbasi.momondo.di.module.NetModule
import ir.hosseinabbasi.momondo.di.module.UtilsModule
import ir.hosseinabbasi.momondo.di.qualifiers.ApplicationContext
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Singleton
@Component(modules = arrayOf(ApplicationModule::class, DataModule::class, NetModule::class, UtilsModule::class))
interface ApplicationComponent : DataComponent, NetComponent, UtilsComponent {

    fun inject(app: MyApplication)

    @ApplicationContext
    fun exposeContext(): Context

    fun exposeResources(): Resources

    fun exposeApplication(): Application

    override fun exposeRealmManager(): RealmManager

    override fun exposeIApiService(): IApiService

    override fun exposeThreadTransformer(): ThreadTransformer
}