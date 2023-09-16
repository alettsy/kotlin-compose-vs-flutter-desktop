import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import benchmarks.primes
import infinite_list.LazyList
import infinite_list.PostManager
import kotlin.system.measureTimeMillis

@Composable
@Preview
fun App() {
    val posts = PostManager()

    fun needMore() {
        println("getting more posts")
        posts.getPosts()
    }

    MaterialTheme {
        Row {
            LazyList(
                modifier = Modifier.padding(all=5.dp),
                posts = posts.posts,
                onLoadMore = { needMore() }
            )
            Button(onClick = {
                val time = measureTimeMillis {
                    val x = primes(200000)
                    println(x.last())
                }
                println("Time taken (ms): $time")
            }){
                Text("Primes")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
