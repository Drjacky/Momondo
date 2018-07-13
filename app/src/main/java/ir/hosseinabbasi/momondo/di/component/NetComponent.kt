package ir.hosseinabbasi.momondo.di.component

import ir.hosseinabbasi.momondo.data.network.IApiService
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Singleton
interface NetComponent {
    @Singleton
    fun exposeIApiService(): IApiService
}