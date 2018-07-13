package ir.hosseinabbasi.momondo.utils.rx.impl

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.SingleTransformer
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.IOThreadPref
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.UIThreadPref
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class ViewThreadTransformer @Inject
constructor(@param:IOThreadPref private val subscribeOnScheduler: Scheduler,
            @param:UIThreadPref private val observeOnScheduler: Scheduler) : ThreadTransformer {

    override fun <T> applySchedulers(): SingleTransformer<T, T> {
        return SingleTransformer { single -> single.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler) }
    }
}