package ir.hosseinabbasi.momondo.ui.base


/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IBasePresenter<V : IBaseView, I : IBaseInteractor> {
    fun onAttach(baseView: V)
    fun onDetach()
    fun getView(): V?
    fun getInteractor(): I?
    fun isViewAttached(): Boolean
}