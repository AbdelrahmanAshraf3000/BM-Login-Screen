package com.example.bmapplication

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmapplication.ui.theme.BMApplicationTheme
import com.example.bmapplication.ui.theme.DarkRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMApplicationTheme {

                startScreen()
            }
        }
    }
}

@Composable
fun startScreen(modifier: Modifier = Modifier) {
    var username by remember {
       mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    var transparency by remember {
        mutableFloatStateOf(0.35f)
    }
    transparency = if (username.isNotEmpty() && password.isNotEmpty()) 1f else 0.35f



    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth(0.9f)
                .fillMaxHeight()
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.bm_icon),
                    contentDescription = "Bank Misr"

                )
                Text(
                    text = stringResource(R.string.language),
                    color = DarkRed,
                    fontSize = 22.sp,
                    modifier = modifier.align(Alignment.CenterVertically)
                )
            }

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = stringResource(R.string.Username)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp)
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = stringResource(R.string.Password)) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp)
            )

            Text(
                text = stringResource(R.string.forgot_username_password),
                fontSize = 16.sp,
                textDecoration = TextDecoration.Underline,
                modifier = modifier
                    .align(Alignment.Start)
                    .padding(top = 20.dp)
            )

            Button(
                onClick = {  },
                shape = RoundedCornerShape(8.dp),
                colors = ButtonDefaults.buttonColors(DarkRed),
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 28.dp)
                    .alpha(transparency)
            ) {
                Text(text = stringResource(R.string.login))
            }
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
            ) {
                Text(
                    text = stringResource(R.string.need_help),
                    fontSize = 16.sp
                )
                Text(
                    text = stringResource(R.string.contact_us),
                    fontSize = 16.sp,
                    color = DarkRed,
                    textDecoration = TextDecoration.Underline
                )
            }
            HorizontalDivider(
                color = Color.LightGray,
                thickness = 2.dp,
                modifier = modifier.padding(top = 50.dp)
            )

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.our_products),
                        contentDescription = stringResource(R.string.our_products),
                        modifier = modifier.size(60.dp)
                    )
                    Text(
                        text = stringResource(R.string.our_products),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.exchange_rate),
                        contentDescription = stringResource(R.string.exchange_rat),
                        modifier = modifier.size(60.dp)

                    )
                    Text(
                        text = stringResource(R.string.exchange_rat),
                        textAlign = TextAlign.Center
                    )

                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.security_tips),
                        contentDescription = stringResource(R.string.security_tips),
                        modifier = modifier.size(60.dp)

                    )
                    Text(
                        text = stringResource(R.string.security_tips),
                        textAlign = TextAlign.Center
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.weight(1f)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.nearest_branch_or_atm),
                        contentDescription = stringResource(R.string.nearest_branch_or_atm),
                        modifier = modifier.size(60.dp)

                    )
                    Text(
                        text = stringResource(R.string.nearest_branch_or_atm),
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun startScreenPreview() {
    startScreen()

}