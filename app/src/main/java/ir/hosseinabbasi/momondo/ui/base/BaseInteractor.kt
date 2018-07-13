package ir.hosseinabbasi.momondo.ui.base

import ir.hosseinabbasi.momondo.data.network.IApiService
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
open class BaseInteractor @Inject
constructor(private val mApiService: IApiService) : IBaseInteractor {
    override fun getApiService(): IApiService {
        return mApiService
    }
}
