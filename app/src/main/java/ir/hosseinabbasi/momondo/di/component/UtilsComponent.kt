package ir.hosseinabbasi.momondo.di.component

import ir.hosseinabbasi.momondo.utils.rx.ThreadTransformer

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface UtilsComponent {
    fun exposeThreadTransformer(): ThreadTransformer
}