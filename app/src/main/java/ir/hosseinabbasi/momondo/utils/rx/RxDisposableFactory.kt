package ir.hosseinabbasi.momondo.utils.rx

import ir.hosseinabbasi.momondo.utils.rx.impl.CompositeDisposablesImpl
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class RxDisposableFactory @Inject constructor() {
    fun get(): RxDisposables {
        return CompositeDisposablesImpl()
    }
}