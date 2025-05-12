package com.webbed.haletaquizapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.webbed.haletaquizapp.R
import com.webbed.haletaquizapp.component.CommonButton
import com.webbed.haletaquizapp.navigation.Screen

@Composable
fun ChoiceScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize() // Deep red background

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        ) {

            Spacer(modifier = Modifier.height(24.dp))
            // Logo and title
            Image(
                painter = painterResource(id = R.drawable.logoimg), // Your logo drawable
                contentDescription = "Logo",
                modifier = Modifier
                    .size(300.dp)
                    .padding(bottom = 32.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(8.dp))

            CommonButton(
                text = "ፈተና",
                onClick = {
                    navController.navigate(Screen.Landing.route)
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            CommonButton(
                text = "ጥናት",
                onClick = {
                    navController.navigate(Screen.Signup.route)
                }
            )

        }
    }
}
