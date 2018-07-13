package ir.hosseinabbasi.momondo.ui.flightlist

import android.util.Log
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ir.hosseinabbasi.momondo.data.db.model.MergedResponse
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.ui.base.BasePresenter
import ir.hosseinabbasi.momondo.utils.rx.RxDisposableFactory
import ir.hosseinabbasi.momondo.utils.rx.RxDisposables
import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class FlightListPresenter<V : IFlightListView, I : IFlightListInteractor> @Inject
constructor(interactor: I,
            threadTransformer: ThreadTransformer,
            rxDisposableFactory: RxDisposableFactory) : BasePresenter<V, I>(interactor, threadTransformer, rxDisposableFactory), IFlightListPresenter<V, I> {
    private val threadTransformer: ThreadTransformer = this.mThreadTransformer
    private val disposables: RxDisposables = this.mRxDisposables

    override fun getFlights(body: SearchRequest) {
        mBaseView?.showLoading()
        disposables.add(getInteractor()!!.getFlights(body)
                .subscribeOn(Schedulers.io())
                .flatMap { response ->
                    Observable.just(response)
                            .flatMap { example -> Observable.just(example.offers) }
                            .flatMapIterable { list -> list }
                            .flatMap { offer ->
                                Observable.just(response.flights)
                                        .flatMapIterable { list -> list }
                                        .filter { flight -> offer.flightIndex == flight.id }
                                        .flatMap { flight ->
                                            Observable.just(flight.segmentIndices)
                                                    .flatMapIterable { list -> list }
                                                    .flatMap { segmentId ->
                                                        Observable.just(response.segments)
                                                                .flatMapIterable { list -> list }
                                                                .filter { item -> segmentId == item.id }
                                                                .flatMap { segment ->
                                                                    Observable.just(segment.legIndices)
                                                                            .flatMapIterable { list -> list }
                                                                            .flatMap { legId ->
                                                                                Observable.just(response.legs)
                                                                                        .flatMapIterable { list -> list }
                                                                                        .filter { item -> legId == item.id }
                                                                                        .map { leg ->
                                                                                            MergedResponse(//TODO Do not send Origin and Destination each time.
                                                                                                    response.originName,
                                                                                                    response.originCode,
                                                                                                    response.destinationName,
                                                                                                    response.destinationCode,
                                                                                                    offer, flight, segment, leg)
                                                                                        }
                                                                            }
                                                                }
                                                    }
                                        }
                            }
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { item ->
                            mBaseView?.loadFlights(item)
                            mBaseView?.hideLoading()
                        },
                        { throwable ->
                            mBaseView?.hideLoading()
                            mBaseView?.onError(throwable.message)
                            Log.wtf(TAG, throwable.message + "") //TODO Use Logger Factory, to send exceptions to the server automatically.
                        }))
    }

    companion object {
        private val TAG: String = FlightListPresenter::class.java.simpleName
    }
}