package ir.hosseinabbasi.momondo.ui.flightlist

import android.app.Activity
import android.content.Context
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.BindView
import butterknife.ButterKnife
import ir.hosseinabbasi.momondo.BR
import ir.hosseinabbasi.momondo.R
import ir.hosseinabbasi.momondo.data.db.model.MergedResponse
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.data.db.model.ToFromItem
import ir.hosseinabbasi.momondo.di.qualifiers.ActivityContext
import ir.hosseinabbasi.momondo.ui.base.BaseFragment
import ir.hosseinabbasi.momondo.ui.main.MainActivity
import ir.hosseinabbasi.momondo.utils.Constants
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class FlightListView : BaseFragment(), IFlightListView {

    @Inject
    @field:ActivityContext
    lateinit var mContext: Context

    @Inject
    lateinit var mPresenter: IFlightListPresenter<IFlightListView, IFlightListInteractor>

    @BindView(R.id.fragment_flightlist_rcyFlights)
    lateinit var mRcyFlights: RecyclerView

    private lateinit var adapter: FlightListAdapter
    private lateinit var mLayoutManager: LinearLayoutManager

    private var mFirstTime: Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater.inflate(R.layout.fragment_flightlist, container, false)
        getActivityComponent()?.inject(this)
        setUnBinder(ButterKnife.bind(this, view))
        mPresenter.onAttach(this)
        initViews()
        return view
    }

    override fun onDestroyView() {
        mPresenter.onDetach()
        super.onDestroyView()
    }

    private fun initViews() {
        mLayoutManager = LinearLayoutManager(mContext)
        mRcyFlights.layoutManager = mLayoutManager
        mRcyFlights.setHasFixedSize(true)
        adapter = FlightListAdapter(this)
        mRcyFlights.adapter = adapter

        if (isNetworkConnected()) run {
            getFlightList()
        }
    }

    private fun getFlightList() {
        val searchRequest = SearchRequest(
                Constants.ORIGIN, Constants.DESTINATION, Constants.DEPARTUREDATE,
                Constants.RETURNDATE, Constants.TICKETCOUNT
        )
        mPresenter.getFlights(searchRequest)
    }

    override fun loadFlights(flight: MergedResponse) {
        /*if(mFirstTime){ //TODO
            val toFromModel = ToFromItem(flight.originName, flight.originCode
            , flight.destinationName, flight.destinationCode)
            val flightListBinding =
                    DataBindingUtil.setContentView<ViewDataBinding>(mContext as Activity, R.layout.fragment_flightlist)
            flightListBinding.setVariable(BR.ToFromModel, toFromModel)
            mFirstTime = false
        }*/
        adapter.add(flight)
        adapter.notifyDataSetChanged()
    }

    companion object {
        val TAG: String = FlightListView::class.java.simpleName

        fun getInstance(): FlightListView {
            return FlightListView()
        }
    }
}