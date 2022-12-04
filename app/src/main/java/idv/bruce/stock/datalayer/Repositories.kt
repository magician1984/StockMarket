package idv.bruce.stock.datalayer

import idv.bruce.stock.datalayer.network.NetworkDataSource
import idv.bruce.stock.datalayer.structure.News

class Repositories private constructor(){
    companion object{
        private var instance : Repositories? = null

        fun getInstance():Repositories = instance ?: Repositories().also { instance = it }
    }

    private val remoteDateSource:NetworkDataSource = NetworkDataSource()

    init {
        remoteDateSource.init()
    }

    fun getNewsList() : List<News>?{
        return process<IRecord.NewsList>(DataType.NEWS_LIST)?.data
    }

    private fun <T> process(dataType: DataType) : T?{
        return remoteDateSource[dataType] as? T
    }
}