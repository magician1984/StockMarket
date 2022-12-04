package idv.bruce.stock.uilayer.newslist

import idv.bruce.stock.datalayer.structure.News
import idv.bruce.stock.ui.base.UiState

class NewsListState(isProgress:Boolean = false, error:Throwable? = null, data : List<News>? = null): UiState(isProgress, error, data)