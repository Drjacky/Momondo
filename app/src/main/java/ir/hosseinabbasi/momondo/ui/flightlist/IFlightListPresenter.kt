package ir.hosseinabbasi.momondo.ui.flightlist

import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.ui.base.IBasePresenter

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IFlightListPresenter<V : IFlightListView, I : IFlightListInteractor> : IBasePresenter<V, I>{
    fun getFlights(body: SearchRequest)
}