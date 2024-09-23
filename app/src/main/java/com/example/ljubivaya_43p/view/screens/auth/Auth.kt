package com.example.ljubivaya_43p.view.screens.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.ljubivaya_43p.R
import com.example.ljubivaya_43p.view.mainActivity.MainViewModel

@Composable
fun Auth(navHostController: NavHostController) {

    val vm = viewModel { AuthViewModel() }

    val viewModel = MainViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()// Занимаем все доступное пространство
            .background(Color.LightGray)// Фон формы
            .padding(16.dp), // Отступы для содержимого
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "АВТОРИЗАЦИЯ",
            fontSize = 24.sp,    fontWeight = FontWeight.Bold,
            color = Color.Black,    textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 16.dp))
        TextField(
            value = vm.userEmail,
            shape = RoundedCornerShape(16.dp),
            textStyle = TextStyle(fontSize = 25.sp),
            onValueChange = { newText -> vm.userEmail = newText }
        )
        Spacer(modifier = Modifier.height(16.dp))
        var passwordVisibility: Boolean by remember { mutableStateOf(false) }
        TextField(value = vm.userPassword,
            shape = RoundedCornerShape(16.dp),
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            leadingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    if(passwordVisibility) {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_24),
                            contentDescription = ""
                        )
                    }
                    else {
                        Icon(
                            painter = painterResource(id = R.drawable.baseline_person_off_24),
                            contentDescription = ""
                        )
                    }
                }
            },

            onValueChange = { newText -> vm.userPassword = newText })
        Spacer(modifier = Modifier.width(10.dp))
        Row( // Используем Row, чтобы расположить кнопки горизонтально
            modifier = Modifier.fillMaxWidth(), // Кнопки заполняют всю ширину
            horizontalArrangement = Arrangement.SpaceBetween // Равномерное распределение кнопок
        ) {
            Spacer(modifier = Modifier.width(33.dp)) // Отступ от левого края

            Button(
                onClick = { vm.onSignInEmailPassword(navHostController) },
                shape = RoundedCornerShape(16.dp), // Закругленные углы
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray, // Серый цвет
                    contentColor = Color.Black
                )
            ){
                Text("Вход", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.width(1.dp)) // Отступ между кнопками

            Button(
                onClick = { viewModel.onSignUpEmail(vm.userEmail, vm.userPassword) },
                shape = RoundedCornerShape(16.dp), // Закругленные углы
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray, // Серый цвет
                    contentColor = Color.Black
                )
            ) {
                Text("Регистрация", fontSize = 20.sp)
            }

            Spacer(modifier = Modifier.width(33.dp)) // Отступ от правого края
        }

        Spacer(modifier = Modifier.height(16.dp))
    }

}