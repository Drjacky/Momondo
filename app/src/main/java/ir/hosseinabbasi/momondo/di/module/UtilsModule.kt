package ir.hosseinabbasi.momondo.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.momondo.utils.rx.RxDisposables
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import ir.hosseinabbasi.momondo.utils.rx.impl.CompositeDisposablesImpl
import ir.hosseinabbasi.momondo.utils.rx.impl.ViewThreadTransformer
import ir.hosseinabbasi.momondo.utils.rx.impl.WorkThreadTransformer
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.IOThreadPref
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.UIThreadPref
import ir.hosseinabbasi.momondo.utils.rx.qualifiers.WorkThreadTransformerPref
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Module
class UtilsModule {

    @Provides
    @Singleton
    internal fun providesViewThreadTransformer(
            transformer: ViewThreadTransformer): ThreadTransformer {
        return transformer
    }

    @Provides
    @Singleton
    @WorkThreadTransformerPref
    internal fun providesWorkThreadTransformer(
            transformer: WorkThreadTransformer): ThreadTransformer {
        return transformer
    }

    @Provides
    @Singleton
    @IOThreadPref
    internal fun provideIoScheduler(): Scheduler {
        return Schedulers.io()
    }

    @Provides
    @Singleton
    @UIThreadPref
    internal fun provideMainScheduler(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    @Provides
    @Singleton
    fun provideCompositeDisposables(
            disposables: CompositeDisposablesImpl): RxDisposables {
        return disposables
    }
}