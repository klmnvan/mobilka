package com.example.ljubivaya_43p.view.screens.mainscreen

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ljubivaya_43p.domain.Constant
import com.example.ljubivaya_43p.model.Product
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.launch

class MainScreenViewModel: ViewModel() {

    var products by mutableStateOf<List<Product>>(listOf())

    fun getProducts() {
        viewModelScope.launch {
            try {
                products = Constant.supabase.from("products")
                    .select().decodeList<Product>()
                Log.d("product", products.toString())

            } catch (e: Exception) {
                println(e.message.toString())
            }
        }
    }


}