package ir.hosseinabbasi.momondo.data.network

import io.reactivex.Observable
import ir.hosseinabbasi.momondo.data.db.model.SearchRequest
import ir.hosseinabbasi.momondo.data.db.model.SearchResponse
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Singleton
class ApiService @Inject
constructor(retrofit: Retrofit) : IApiService{
    private val mRetrofit = retrofit

    override fun getFlights(body: SearchRequest): Observable<SearchResponse> {
        return mRetrofit.create(IApiService::class.java).getFlights(body)
    }
}