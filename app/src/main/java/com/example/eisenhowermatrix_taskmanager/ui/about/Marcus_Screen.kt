package com.example.eisenhowermatrix_taskmanager.ui.about


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eisenhowermatrix_taskmanager.R

@Composable
fun MarcusProfile() {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = Color(android.graphics.Color.parseColor("#ececec"))),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Meio círculo no topo
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(182.dp) // Altura ajustável conforme necessário
                .background(color = Color.Transparent)
        ) {
            Image(
                painter = painterResource(id = R.drawable.top_background),
                contentDescription = "Meio círculo superior",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.FillWidth
            )
            // Espaçamento entre o topo e a imagem de perfil
            Spacer(modifier = Modifier.height(-70.dp))

            // Imagem de perfil
            Image(
                painter = painterResource(id = R.drawable.marcus),
                contentDescription = "Imagem de perfil",
                modifier = Modifier
                    .size(150.dp) // Tamanho ajustável conforme necessário
                    .background(color = Color.Transparent)
                    .align(Alignment.Center)
                    .offset(x = 0.dp, y = 80.dp)
                    .border(4.dp, Color.White, CircleShape)

            )

        }
        Text(
            "Marcus Vinicius Gonçalves",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 80.dp),
            color = Color(android.graphics.Color.parseColor("#747679"))
        )
        Spacer(modifier = Modifier.height(40.dp))
        ProfileOptionRow(R.drawable.emailicon, "   reveriejacket@hotmail.com", 30)
        ProfileOptionRow(R.drawable.github_logo, "https://github.com/ReverieJacket", 30)
        ProfileOptionRow(R.drawable.phone, "         (81) 9 9278-7416", 30)

    }
}

@Composable
fun ProfileOptionRow(icon: Int, text: String,size: Int) {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp, vertical = 20.dp)
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .border(1.dp, Color.LightGray, shape = RoundedCornerShape(8.dp))
            //.clickable { /* Ação de clique */ }
            .padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color(android.graphics.Color.parseColor("#747679")),
            modifier = Modifier.size(size.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            color = Color(android.graphics.Color.parseColor("#747679")
            )
        )
    }
}
