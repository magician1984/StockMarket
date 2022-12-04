package idv.bruce.stock.uilayer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import idv.bruce.stock.datalayer.structure.News
import idv.bruce.stock.ui.theme.StockMarketTheme
import idv.bruce.stock.uilayer.newslist.NewsListPage
import idv.bruce.stock.uilayer.newslist.NewsListViewModel

//https://openapi.twse.com.tw/#/%E5%85%B6%E4%BB%96/get_news_newsList
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NewsListPage(viewModels<NewsListViewModel>())
                }
            }
        }
    }
}
