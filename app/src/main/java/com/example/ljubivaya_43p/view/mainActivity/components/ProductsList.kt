package com.example.ljubivaya_43p.view.mainActivity.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ljubivaya_43p.domain.Constant
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.example.ljubivaya_43p.model.products
import io.github.jan.supabase.storage.BucketItem
import android.widget.Toast as WToast


@Composable
fun CountriesList() {
    var products by remember { mutableStateOf<List<products>>(listOf()) }
    var bucket: ByteArray? = null
    var bytes:ByteArray? = null
    var files: List<BucketItem>? = null
    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            products = Constant.supabase.from("Products")
                .select().decodeList<products>()
            products.forEach{it->
                Log.d("C", it.name)
            }
        }
    }

    LazyColumn {

        items(
            products,
            key = { products -> products.id },
        ) { products ->
            val imageState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current).data(products.image)
                    //.size(Size.ORIGINAL).build()
            ).state
            if (imageState is AsyncImagePainter.State.Error) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            if (imageState is AsyncImagePainter.State.Success) {
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    painter = imageState.painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                products.name,
                modifier = Modifier.padding(8.dp),
           )

        }
    }
}