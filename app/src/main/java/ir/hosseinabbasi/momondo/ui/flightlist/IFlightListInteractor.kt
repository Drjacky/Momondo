package ir.hosseinabbasi.momondo.ui.flightlist

import io.reactivex.Observable
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.data.db.model.SearchResponse
import ir.hosseinabbasi.momondo.ui.base.IBaseInteractor

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IFlightListInteractor : IBaseInteractor{
    fun getFlights(body: SearchRequest): Observable<SearchResponse>
}