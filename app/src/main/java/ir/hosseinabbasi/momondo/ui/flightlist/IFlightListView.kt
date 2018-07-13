package ir.hosseinabbasi.momondo.ui.flightlist

import ir.hosseinabbasi.momondo.data.db.model.MergedResponse
import ir.hosseinabbasi.momondo.ui.base.IBaseView

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IFlightListView : IBaseView{
    fun loadFlights(flight: MergedResponse)
}