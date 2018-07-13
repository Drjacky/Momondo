package ir.hosseinabbasi.momondo.ui.flightlist

import io.reactivex.Observable
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.data.db.model.SearchResponse
import ir.hosseinabbasi.momondo.data.network.IApiService
import ir.hosseinabbasi.momondo.ui.base.BaseInteractor
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
/**
 * Each page that needs other Helper classes, should inject them into constructor; But cause
 * ApiService usage is general, it's added at beginning into BaseInteractor.
 */
class FlightListInteractor @Inject
constructor(apiService: IApiService) : BaseInteractor(apiService), IFlightListInteractor{
    override fun getFlights(body: SearchRequest): Observable<SearchResponse> {
        return getApiService().getFlights(body)
    }
}