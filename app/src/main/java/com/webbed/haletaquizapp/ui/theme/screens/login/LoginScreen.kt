package com.webbed.haletaquizapp.ui.theme.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.VpnKey
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.ui.theme.Screen
import com.webbed.haletaquizapp.ui.theme.component.CommonButton
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun LoginScreen(
    onForgotPasswordClick: () -> Unit,
    onSignUpClick: () -> Unit,
    navController: NavController,
    viewModel: LoginViewModel = viewModel()
) {
    val username = viewModel.username
    val password = viewModel.password
    val role = viewModel.role
    val errorMessage = viewModel.errorMessage

    Column(
        modifier = Modifier
            .fillMaxSize()
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
            text = "ለመግባት",
            color = Color(0xFFFAD6BF),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { viewModel.onUsernameChange(it) },
            placeholder = { Text("መለያ", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "User")},
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

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { viewModel.onPasswordChange(it) },
            placeholder = { Text("የይለፍ ቃል", color = Color(0xFF8B0000),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,) },
            leadingIcon = {
                Icon(imageVector = Icons.Filled.VpnKey, contentDescription = "Password")
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFF0DDE0)),
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

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            listOf("student" to "ተማሪ", "admin" to "አስተዳዳሪ").forEach { (value, label) ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = role == value,
                        onClick = { viewModel.onRoleSelected(value) },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color(0xFFF0DDE0),
                            unselectedColor = Color(0xFFF0DDE0),
                            disabledSelectedColor = Color(0xFFF0DDE0),
                            disabledUnselectedColor = Color(0xFFF0DDE0)
                        )
                    )
                    Text(label, color = Color(0xFFF0DDE0))
                }
                Spacer(modifier = Modifier.width(16.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        CommonButton(
            text = "ግባ",
            onClick = {
                viewModel.validateAndNavigate(
                    navigateToStudent = { navController.navigate(Screen.Choice.route) },
                    navigateToAdmin = { navController.navigate(Screen.Landing.route) }
                )
            }
        )

        errorMessage?.let {
            Text(
                text = it,
                color = Color.Red,
                modifier = Modifier.padding(top = 8.dp),
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        CommonButton(
            text = "የይለፍ ቃል ከረሱ",
            onClick = { onForgotPasswordClick() }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text("ከዚህ በፊት አልተመዘገቡም?", color = Color.White)
        }

        CommonButton(
            text = "ይመዝገቡ",
            onClick = { onSignUpClick() }
        )
    }
}
