package ir.hosseinabbasi.momondo.data.db.helper

import ir.hosseinabbasi.momondo.data.db.RealmManager
import javax.inject.Inject

/**
 * Created by Dr.jacky on 2018/06/29.
 */
/**
 * Created to just to show how to work with DbHelper and prevent the project from Anti-Pattern;
 * (Inject Helper classes only to classes that need it)
 */
class FlightDbHelper @Inject
constructor(private val mRealmManager: RealmManager){
    //TODO Just to show one usage. Keep in mind to extend the each model from RealmObject.
    /*fun insert(flight: FlightsItem) {
        val realm = mRealmManager.getLocalInstance()
        val flightResult = realm.where(FlightsItem::class.java)
                .equalTo(FlightsItemFields.ID, flight.id ?: "-1").findFirst()
        realm.executeTransaction { realm1 -> realm1.insertOrUpdate(flight) }
    }*/
}