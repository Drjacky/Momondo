package ir.hosseinabbasi.momondo.utils.rx

import io.reactivex.ObservableTransformer
import io.reactivex.SingleTransformer

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface ThreadTransformer {
    fun <T> applySchedulers(): SingleTransformer<T, T>
}