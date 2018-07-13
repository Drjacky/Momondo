package ir.hosseinabbasi.momondo.ui.flightlist

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import ir.hosseinabbasi.momondo.R
import ir.hosseinabbasi.momondo.data.db.model.MergedResponse
import ir.hosseinabbasi.momondo.databinding.FlightItemBinding

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class FlightListAdapter(private val mListener: IFlightListView) : RecyclerView.Adapter<FlightListAdapter.DataHolder>() {
    private var mMergedItems: MutableList<MergedResponse> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataHolder {
        val bind: FlightItemBinding = DataBindingUtil.inflate<ViewDataBinding>(LayoutInflater.from(parent.context),
                R.layout.flight_item, parent, false) as FlightItemBinding

        return DataHolder(bind)
    }

    override fun onBindViewHolder(holder: DataHolder, position: Int) {
        val eventsItemModel = mMergedItems[holder.adapterPosition]
        holder.bind(eventsItemModel)
    }

    override fun getItemCount(): Int {
        return mMergedItems.size
    }

    fun add(item: MergedResponse) {
        mMergedItems.add(item)
    }

    inner class DataHolder(private var flightItemBinding: FlightItemBinding) : RecyclerView.ViewHolder
    (flightItemBinding.root), View.OnClickListener {
        init {
            ButterKnife.bind(this, flightItemBinding.root)
        }

        fun bind(flight: MergedResponse) {
            flightItemBinding.flights = flight
            flightItemBinding.executePendingBindings()
        }

        override fun onClick(view: View) {
            //TODO Just to show how to handle click listener on a row
            /*val flight: FlightsItem = mMergedItems[adapterPosition]
            mListener.blah(flight)*/
        }

    }
}