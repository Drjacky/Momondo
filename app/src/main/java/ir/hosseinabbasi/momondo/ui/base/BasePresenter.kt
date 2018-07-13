package ir.hosseinabbasi.momondo.ui.base

import android.arch.lifecycle.LifecycleObserver
import android.os.Bundle
import ir.hosseinabbasi.momondo.utils.rx.RxDisposableFactory
import ir.hosseinabbasi.momondo.utils.rx.RxDisposables
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import javax.inject.Inject


/**
 * Created by Dr.jacky on 2018/06/29.
 */
open class BasePresenter<V : IBaseView, I : IBaseInteractor> @Inject
constructor(mInteractor: I,
            val mThreadTransformer: ThreadTransformer,
            mRxDisposableFactory: RxDisposableFactory) : IBasePresenter<V, I>, LifecycleObserver {

    var mRxDisposables: RxDisposables = mRxDisposableFactory.get()
        private set

    var mStateBundle: Bundle? = null

    var mBaseView: V? = null
        private set

    var mBaseInteractor: I? = null
        private set

    init {
        mBaseInteractor = mInteractor
    }

    override fun onAttach(baseView: V) {
        mBaseView = baseView
    }

    override fun onDetach() {
        mRxDisposables.clear()
        mBaseView = null
        mBaseInteractor = null
    }

    override fun getView(): V? {
        return mBaseView
    }

    override fun getInteractor(): I? {
        return mBaseInteractor
    }

    override fun isViewAttached(): Boolean {
        return mBaseView != null
    }

    fun checkViewAttached() {
        if (!isViewAttached()) throw BaseViewNotAttachedException()
    }

    class BaseViewNotAttachedException : RuntimeException("Please call Presenter.onAttach(IBaseView) before" + " requesting data to the Presenter")
}