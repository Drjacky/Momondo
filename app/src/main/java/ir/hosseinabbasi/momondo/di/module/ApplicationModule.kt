package ir.hosseinabbasi.momondo.di.module

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.momondo.di.qualifiers.ApplicationContext
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    fun provideApplicationContext(): Context {
        return mApplication
    }

    @Provides
    fun provideApplication(): Application {
        return mApplication
    }

    @Provides
    @Singleton
    fun provideAppResources(): Resources {
        return mApplication.resources
    }
}