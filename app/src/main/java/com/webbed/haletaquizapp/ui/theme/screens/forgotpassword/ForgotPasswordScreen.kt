package com.webbed.haletaquizapp.ui.theme.screens.forgotpassword

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.launch


@Composable
fun ForgotPasswordScreen(
    navController: NavController,
    viewModel: ForgotPasswordViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    val context = LocalContext.current

    val username by viewModel.username.collectAsState()
    val answer1 by viewModel.answer1.collectAsState()
    val answer2 by viewModel.answer2.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.logoimg),
            contentDescription = "Logo",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
        )

        Text(
            text = "የይለፍ ቃል ከረሱት?",
            color = Color(0xFFFAD6BF),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = viewModel::onUsernameChange,
            placeholder = {
                Text("መለያ", color = Color(0xFF8B0000), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            },
            leadingIcon = { Icon(Icons.Filled.Person, contentDescription = null) },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0), RoundedCornerShape(8.dp)),
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
            text = "የጥያቄዎች መልስ ያስገቡ",
            fontSize = 20.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("ጥያቄ 1: የእናትዎ የመጀመሪያ ስም ማን ነው?", color = Color.White)
        OutlinedTextField(
            value = answer1,
            onValueChange = viewModel::onAnswer1Change,
            placeholder = {
                Text("መልስ 1", color = Color(0xFF8B0000), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0), RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text("ጥያቄ 2: የትውልድ ከተማዎ ማን ነው?", color = Color.White)
        OutlinedTextField(
            value = answer2,
            onValueChange = viewModel::onAnswer2Change,
            placeholder = {
                Text("መልስ 2", color = Color(0xFF8B0000), fontSize = 20.sp, fontWeight = FontWeight.Bold)
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0), RoundedCornerShape(8.dp)),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            CommonButton(
                text = "ተመለስ",
                onClick = {
                    navController.navigate("Login")
                },
                modifier = Modifier.weight(1f)
            )
            CommonButton(
                text = "ቀጥል",
                onClick = {
                    viewModel.validateSecurityAnswers(
                        onSuccess = {
                            CoroutineScope(Dispatchers.Main).launch {
                                navController.navigate("ResetPassword")
                            }
                        },
                        onError = { message ->
                            CoroutineScope(Dispatchers.Main).launch {
                                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                },
                modifier = Modifier.weight(1f)
            )
        }
    }
}