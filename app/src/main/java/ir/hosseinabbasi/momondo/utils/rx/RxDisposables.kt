package ir.hosseinabbasi.momondo.utils.rx

import io.reactivex.disposables.Disposable

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface RxDisposables {
    fun add(disposable: Disposable)

    fun clear()
}