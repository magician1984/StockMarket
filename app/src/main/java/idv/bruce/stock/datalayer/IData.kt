package idv.bruce.stock.datalayer

import idv.bruce.stock.datalayer.structure.News

sealed class IRecord<T>(val data : T? = null) {
    val updateTime :Long = System.currentTimeMillis()


    class NewsList(list : List<News>) : IRecord<List<News>>(list)
}