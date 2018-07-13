package ir.hosseinabbasi.momondo.ui.base

import ir.hosseinabbasi.momondo.data.network.IApiService


/**
 * Created by Dr.jacky on 2018/06/29.
 */
/**
 * Lists APIs method and Helper classes that are common to all application components.
 */
interface IBaseInteractor{
    fun getApiService(): IApiService
}