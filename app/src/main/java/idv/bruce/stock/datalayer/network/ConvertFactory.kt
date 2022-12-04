package idv.bruce.stock.datalayer.network

import android.os.Build
import androidx.annotation.RequiresApi
import idv.bruce.stock.datalayer.IRecord
import idv.bruce.stock.datalayer.structure.News
import okhttp3.ResponseBody
import org.json.JSONArray
import org.json.JSONException
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type


class ConvertFactory : Converter.Factory() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun responseBodyConverter(
        type: Type,
        annotations: Array<out Annotation>,
        retrofit: Retrofit
    ): Converter<ResponseBody, *>? {
        if (type !is Class<*>)
            return null
        return when{
            IRecord.NewsList::class.java.isAssignableFrom(type)-> NewsListResponseConvertor()
            else -> null
        }
    }

    private class NewsListResponseConvertor : Converter<ResponseBody, IRecord.NewsList> {
        override fun convert(value: ResponseBody): IRecord.NewsList? {
            try {
                val arr: JSONArray = JSONArray(value.string())

                val list: ArrayList<News> = ArrayList()

                val count = arr.length()

                for (i in 0 until count) {
                    with(arr.getJSONObject(i)) {
                        list.add(
                            News(
                                this.getString("Title"),
                                this.getString("Url"),
                                this.getString("Date")
                            )
                        )
                    }
                }
                return IRecord.NewsList(list)
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return null
        }
    }

}