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
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import idv.bruce.stock.datalayer.structure.News
import idv.bruce.stock.ui.theme.StockMarketTheme
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

//https://openapi.twse.com.tw/#/%E5%85%B6%E4%BB%96/get_news_newsList
class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StockMarketTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                }
            }
        }
    }
}

@Composable
fun NewsList(list: List<News>?) {
    val mList: List<News> = list ?: return
    LazyColumn(){
        items(items = mList){
            Card(modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()) {
                Text(text = it.title)
            }
        }
    }
}
