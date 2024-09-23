package com.example.ljubivaya_43p.view.screens.adminscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.ljubivaya_43p.R
import com.example.ljubivaya_43p.view.screens.auth.AuthViewModel

@Composable
fun AdminScreen(navHostController: NavHostController) {

    val vm = viewModel { AdminScreenViewModel() }

    LaunchedEffect(Unit) {
        vm.getProducts()
    }

    Column(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        LazyColumn {
            items(
                vm.products,
                key = { products -> products.id },
            ) { product ->
                val imageState = rememberAsyncImagePainter(
                    model = ImageRequest.Builder(LocalContext.current).data(product.image)
                        .size(coil.size.Size.ORIGINAL).build()
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
                val name = remember { mutableStateOf(product.name.toString()) }
                TextField(
                    value = name.value,
                    shape = RoundedCornerShape(16.dp),
                    onValueChange = { newText -> name.value = newText })

                val price = remember { mutableStateOf(product.price.toString()) }
                TextField(
                    value = price.value,
                    shape = RoundedCornerShape(16.dp),
                    onValueChange = { newText -> price.value = newText })
                Text(
                    product.name,
                    modifier = Modifier.padding(8.dp),
                )
                Button(
                    onClick = { vm.updateProduct(product.id, name.value, price.value) },
                    shape = RoundedCornerShape(16.dp), // Закругленные углы
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Gray, // Серый цвет
                        contentColor = Color.Black
                    )
                ) {
                    Text("Изменить", fontSize = 20.sp)
                }
            }
        }
    }

}