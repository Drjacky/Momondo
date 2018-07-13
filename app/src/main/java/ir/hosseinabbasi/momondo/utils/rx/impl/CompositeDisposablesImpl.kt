package ir.hosseinabbasi.momondo.utils.rx.impl

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import ir.hosseinabbasi.momondo.utils.rx.RxDisposables
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class CompositeDisposablesImpl @Inject
constructor() : RxDisposables {

    var compositeDisposable = CompositeDisposable()

    override fun add(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun clear() {
        compositeDisposable.clear()
    }
}