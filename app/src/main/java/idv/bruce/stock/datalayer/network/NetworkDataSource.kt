package idv.bruce.stock.datalayer.network

import idv.bruce.stock.BuildConfig
import idv.bruce.stock.datalayer.DataType
import idv.bruce.stock.datalayer.IDataSource
import idv.bruce.stock.datalayer.IRecord
import idv.bruce.stock.datalayer.structure.News
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit

internal class NetworkDataSource : IDataSource {
    private companion object {
        const val BASE_URL = "https://openapi.twse.com.tw/v1/"
    }

    private lateinit var api: Api

    override fun init() {
        val client: OkHttpClient = OkHttpClient().newBuilder().apply {
            if (BuildConfig.DEBUG)
                addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                })
        }.build()

        val retrofit: Retrofit = Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(ConvertFactory())
            .build()

        api = retrofit.create(Api::class.java)
    }

    override fun release() {

    }

    override fun set(s: DataType, value: Any) {

    }

    override fun get(s: DataType): Any? {
        return when (s) {
            DataType.NEWS_LIST -> getNewsList()
        }
    }


    private fun getNewsList(): IRecord.NewsList? {
        val call: Call<IRecord.NewsList> = api.getNewsList()

        val response = call.execute()

        return response.body()
    }
}