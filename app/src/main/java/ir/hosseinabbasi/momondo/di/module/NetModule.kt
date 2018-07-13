package ir.hosseinabbasi.momondo.di.module

import dagger.Module
import dagger.Provides
import ir.hosseinabbasi.momondo.data.network.ApiEndPoint
import ir.hosseinabbasi.momondo.data.network.ApiService
import ir.hosseinabbasi.momondo.data.network.IApiService
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Dr.jacky on 2018/06/29.
 */
@Module
class NetModule {

    @Provides
    @Singleton
    fun provideApiService(apiService: ApiService): IApiService {
        return apiService
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        //TODO Just to show how to add some parameters into request header.
        /*val client = OkHttpClient.Builder()
                .addInterceptor { chain ->
                    var request = chain.request()
                    val url = request.url()
                            .newBuilder()
                            .addQueryParameter("apikey", ApiEndPoint.API_KEY)
                            .build()
                    request = request.newBuilder().url(url).build()
                    chain.proceed(request)
                }.build()*/

        return Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiEndPoint.ENDPOINT_MOMONDO)
                //.client(client)
                .build()
    }
}