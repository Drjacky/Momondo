package ir.hosseinabbasi.momondo.di.module

import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.momondo.data.db.RealmManager
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideRealmManager(): RealmManager {
        return RealmManager()
    }
}