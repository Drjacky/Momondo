package ir.hosseinabbasi.momondo.ui.main

import ir.hosseinabbasi.momondo.ui.base.BasePresenter
import ir.hosseinabbasi.momondo.utils.rx.RxDisposableFactory
import ir.hosseinabbasi.momondo.utils.rx.RxDisposables
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class MainActivityPresenter<V : IMainActivityView, I : IMainActivityInteractor> @Inject
constructor(interactor: I,
            threadTransformer: ThreadTransformer,
            rxDisposableFactory: RxDisposableFactory) : BasePresenter<V, I>(interactor, threadTransformer, rxDisposableFactory), IMainActivityPresenter<V, I> {
    private val threadTransformer: ThreadTransformer = this.mThreadTransformer
    private val disposables: RxDisposables = this.mRxDisposables
}