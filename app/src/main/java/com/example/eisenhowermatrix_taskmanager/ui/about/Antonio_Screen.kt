package com.example.eisenhowermatrix_taskmanager.ui.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix_taskmanager.R

@Composable
fun AntonioProfile(modifier: Modifier = Modifier) {
    Surface(color = Color(0, 0, 0)) {

        Surface {
            Image(
                painter = painterResource(id = R.drawable.papel_de_parede_estrelado),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop // Isso ajusta a imagem para preencher a tela
            )
        }
        Column(
            modifier = modifier
                .fillMaxHeight()
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(
                    id = R.drawable.antonio
                ),
                contentDescription = "Descrição da imagem",
                modifier = modifier
                    .height(120.dp)
                    .width(120.dp)
                    .clip(CircleShape)
            )
            Text(
                text = "Antonio Henrique",
                color = Color.White,
                fontSize = 40.sp

            )
            Text(
                text = "Android Developer",
                fontSize = 20.sp,
                color = Color(0xFF3ddc84)
            )
            Column(
                modifier = Modifier.padding(top = 200.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_celular),
                        contentDescription = null,
                        tint = Color(0xFF3ddc84),
                        modifier = Modifier.padding(start = 50.dp, end = 30.dp)
                    )
                    Text(
                        text = "+55 87991378933",
                        color = Color(0xffffffff),
                        textAlign = TextAlign.Start
                    )
                }
                HorizontalDivider(
                    modifier = Modifier.padding(
                        start = 20.dp,
                        end = 20.dp,
                        top = 10.dp,
                        bottom = 10.dp
                    ),
                    color = Color(0xffffffff)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arroba),
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.padding(start = 50.dp, end = 30.dp)
                )
                Text(
                    text = "antoniohenriquef101@gmail.com",
                    color = Color(0xffffffff),
                    textAlign = TextAlign.Start
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                color = Color(0xffffffff)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                horizontalArrangement = Arrangement.Start

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_lptgit),
                    contentDescription = null,
                    tint = Color(0xFF3ddc84),
                    modifier = Modifier.padding(start = 50.dp, end = 30.dp)
                )
                Text(
                    text = "GIT: AntonioH1",
                    color = Color(0xffffffff),
                    textAlign = TextAlign.Start
                )
            }
            HorizontalDivider(
                modifier = Modifier.padding(
                    start = 20.dp,
                    end = 20.dp,
                    top = 10.dp,
                    bottom = 10.dp
                ),
                color = Color(0xffffffff)
            )
        }
    }
}