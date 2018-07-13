package ir.hosseinabbasi.momondo.di.component

import ir.hosseinabbasi.momondo.data.db.RealmManager
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Singleton
interface DataComponent {
    @Singleton
    fun exposeRealmManager(): RealmManager
}