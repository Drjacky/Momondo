package ir.hosseinabbasi.momondo.utils.rx.impl

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.IOThreadPref
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class WorkThreadTransformer @Inject
constructor(@param:IOThreadPref private val subscribeOnScheduler: Scheduler,
            @param:IOThreadPref private val observeOnScheduler: Scheduler) :  ThreadTransformer {

    override fun <T> applySchedulers(): SingleTransformer<T, T> {
        return SingleTransformer { single -> single.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler) }
    }
}