package ir.hosseinabbasi.momondo.ui.main

import android.os.Bundle
import butterknife.ButterKnife
import ir.hosseinabbasi.momondo.R
import ir.hosseinabbasi.momondo.ui.base.BaseActivity
import ir.hosseinabbasi.momondo.ui.flightlist.FlightListView
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
class MainActivity : BaseActivity(), IMainActivityView {

    @Inject
    lateinit var mPresenter: IMainActivityPresenter<IMainActivityView, IMainActivityInteractor>

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        setUnBinder(ButterKnife.bind(this))
        initViews()
        mPresenter.onAttach(this)
    }

    public override fun onDestroy() {
        mPresenter.onDetach()
        super.onDestroy()
    }

    private fun initViews() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.activity_main_frmMain, FlightListView.getInstance(), FlightListView.TAG)
                .commit()
    }
}