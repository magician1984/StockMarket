package idv.bruce.stock.datalayer.network

import idv.bruce.stock.datalayer.IRecord
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("news/newsList")
    fun getNewsList() : Call<IRecord.NewsList>
}