package idv.bruce.stock.uilayer.newslist

import android.app.Application
import idv.bruce.stock.ui.base.BaseViewModel

class NewsListViewModel(application : Application): BaseViewModel<NewsListState, NewsListEvent, NewsListEffect>(application) {
    override val initialState : NewsListState
        get() = NewsListState()
}