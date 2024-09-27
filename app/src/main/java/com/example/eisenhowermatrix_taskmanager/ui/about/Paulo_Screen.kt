package com.example.eisenhowermatrix_taskmanager.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix_taskmanager.R

@Composable
fun TopContent(nome: String) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(20.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.paulo),
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
        )
        Text(
            text = nome,
            fontSize = 55.sp,
            color = Color(0xFF54C285),
            lineHeight = 116.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun CenterContent(profissao: String, actualProfissao: String) {
    Box(modifier = Modifier.padding(top = 60.dp)) {
        Image(
            painter = painterResource(R.drawable.androidlogo),
            contentDescription = null,
            alpha = 0.7f,
            modifier = Modifier.align(Alignment.Center)
        )
        Text(
            text = profissao,
            style = TextStyle(
                fontSize = 32.sp,
                color = Color(0xFF54C285),
                textDecoration = TextDecoration.LineThrough
            ),
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 130.dp)
        )
        Text(
            text = actualProfissao,
            fontSize = 32.sp,
            color = Color.DarkGray,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 220.dp)
        )
    }
}

@Composable
fun BottomContent(email: String, github: String, telefone: String) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(60.dp)
    ) {
        Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_email_24),
                contentDescription = "Email: paulosergiolobogoes@gmail.com",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            )
            Text(
                text = email,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_code_24),
                contentDescription = "Github: Paulo_Goes",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            )
            Text(
                text = github,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Row(modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)) {
            Icon(
                painter = painterResource(R.drawable.baseline_contact_phone_24),
                //Número do telelefone removido
                contentDescription = "Phone: +XX X XXXX XXXX",
                tint = Color(0xFFFFFFFF),
                modifier = Modifier.padding(start = 20.dp, end = 10.dp)
            )
            Text(
                text = "Phone: $telefone",
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Composable
fun PauloProfile(
    nome: String,
    profissao: String,
    actualProfissao: String,
    email: String,
    github: String,
    telefone: String
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Gray
    ) {
        TopContent(nome)
        CenterContent(profissao, actualProfissao)
        BottomContent(email, github, telefone)
    }
}