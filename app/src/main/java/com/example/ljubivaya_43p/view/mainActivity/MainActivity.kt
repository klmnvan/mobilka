package com.example.ljubivaya_43p.view.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ljubivaya_43p.domain.Constant.supabase
import com.example.ljubivaya_43p.model.products
import com.example.ljubivaya_43p.view.theme.Ljubivaya_43PTheme
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ljubivaya_43PTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)

                    )
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //ProductsList()
                }

            }
        }
    }
}


//@Composable
//fun ProductsList() {
//    var products by remember { mutableStateOf<List<products>>(listOf()) }
//    LaunchedEffect(Unit) {
//        withContext(Dispatchers.IO) {
//            products = supabase.from("products")
//                .select().decodeList<products>()
//        }
//    }
//    LazyColumn {
//        items(
//            products,
//            key = { products -> products.id },
//        ) { products ->
//            Text(
//                products.name,
//                modifier = Modifier.padding(8.dp),
//            )
//        }
//    }
//}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ljubivaya_43PTheme {
        Greeting("Android")
    }
}