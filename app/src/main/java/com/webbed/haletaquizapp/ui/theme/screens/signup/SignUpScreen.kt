package com.webbed.haletaquizapp.ui.theme.screens.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.ui.theme.component.CommonButton
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SignUpScreen(navController: NavController, viewModel: SignUpViewModel = viewModel()) {
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()


    val resetA1 = viewModel.resetA1.collectAsState().value
    val resetA2 = viewModel.resetA2.collectAsState().value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logoimg),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "ለመመዝገብ",
            color = Color(0xFFFAD6BF),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))



        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.onUsernameChange(it) },
            placeholder = { Text("መለያ", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF0DDE0)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLeadingIconColor = Color.Black,
                unfocusedLeadingIconColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            placeholder = { Text("የይለፍ ቃል", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = { Icon(Icons.Filled.VpnKey, contentDescription = null) },
            modifier = Modifier.fillMaxWidth().background(Color(0xFFF0DDE0)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black,
                focusedLeadingIconColor = Color.Black,
                unfocusedLeadingIconColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "የይለፍ ቃል ለማስተካከል እባክዎን እንዲያውቁት ያስገቡ",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "እጅግ አብዝተው የተደሰቱበት ቀን",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))


        OutlinedTextField(
            value = resetA1,
            onValueChange = { viewModel.onResetA1Changed(it) },
            placeholder = { Text("መልስ 1", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "User") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF460C16),
                unfocusedTextColor = Color.Black,
                focusedLeadingIconColor = Color(0xFF460C16),
                unfocusedLeadingIconColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "መቼም የማይረሱት ቀን",
            fontSize = 16.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(4.dp))

        OutlinedTextField(
            value = resetA2,
            onValueChange = { viewModel.onResetA2Changed(it) },
            placeholder = { Text("መልስ 2", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "User") },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                focusedTextColor = Color(0xFF460C16),
                unfocusedTextColor = Color.Black,
                focusedLeadingIconColor = Color(0xFF460C16),
                unfocusedLeadingIconColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(24.dp))
        CommonButton(
            text = "ተመዝገብ",
            onClick = {
                navController.navigate("ChoiceScreen")
                viewModel.loadUserData(username)
            },
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("አካውንት አለዎት?", color = Color.White)

        CommonButton(
            text = "ይግቡ",
            onClick = {
                navController.navigate("quizScreen")
            },
        )
    }
}
