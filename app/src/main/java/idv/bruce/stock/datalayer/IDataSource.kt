package idv.bruce.stock.datalayer

internal interface IDataSource {
    companion object{
        const val DATA_NEWS = "news"
    }
    fun init()
    fun release()
    operator fun set(s: DataType, value: Any)
    operator fun get(s:DataType):Any?
}