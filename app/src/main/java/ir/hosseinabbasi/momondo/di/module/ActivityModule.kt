package ir.hosseinabbasi.momondo.di.module

import android.app.Activity
import android.content.Context
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import ir.hosseinabbasi.momondo.di.qualifiers.ActivityContext
import ir.hosseinabbasi.momondo.di.qualifiers.PerActivity
import ir.hosseinabbasi.momondo.ui.flightlist.*
import ir.hosseinabbasi.momondo.ui.main.*

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Module
class ActivityModule(private val mActivity: Activity) {

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context {
        return mActivity
    }

    @Provides
    fun provideActivity(): Activity {
        return mActivity
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }

    @Provides
    @PerActivity
    fun provideMainActivityPresenter(presenter: MainActivityPresenter<IMainActivityView, IMainActivityInteractor>):
            IMainActivityPresenter<IMainActivityView, IMainActivityInteractor> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideMainInteractor(interactor: MainActivityInteractor): IMainActivityInteractor {
        return interactor
    }

    @Provides
    @PerActivity
    fun provideFlightListPresenter(presenter: FlightListPresenter<IFlightListView, IFlightListInteractor>):
            IFlightListPresenter<IFlightListView, IFlightListInteractor> {
        return presenter
    }

    @Provides
    @PerActivity
    fun provideFlightListInteractor(interactor: FlightListInteractor): IFlightListInteractor {
        return interactor
    }
}