package ir.hosseinabbasi.momondo.ui.main

import ir.hosseinabbasi.momondo.data.network.IApiService
import ir.hosseinabbasi.momondo.ui.base.BaseInteractor
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class MainActivityInteractor @Inject
constructor(apiService: IApiService) : BaseInteractor(apiService), IMainActivityInteractor