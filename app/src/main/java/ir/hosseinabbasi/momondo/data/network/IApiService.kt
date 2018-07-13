package ir.hosseinabbasi.momondo.data.network

import io.reactivex.Observable
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.data.db.model.SearchResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Dr.jacky on 2018/06/29.
 */
interface IApiService{
    @POST("search")
    fun getFlights(@Body body: SearchRequest): Observable<SearchResponse>
}