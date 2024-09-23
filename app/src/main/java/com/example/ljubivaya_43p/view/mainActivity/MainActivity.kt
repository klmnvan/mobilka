package com.example.ljubivaya_43p.view.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ljubivaya_43p.domain.Navigation
import com.example.ljubivaya_43p.view.theme.Ljubivaya_43PTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ljubivaya_43PTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation()
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