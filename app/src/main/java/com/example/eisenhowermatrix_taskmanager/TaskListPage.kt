package com.example.eisenhowermatrix_taskmanager

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TaskListPage(){
    val taskList = getFakeTask()

    Column (
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ){
        LazyColumn(
            content = {
                itemsIndexed(taskList){ index: Int, item: Task ->

                }
            }
        )
    }
}

@Composable
fun TaskItem(item: Task){
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .padding(8.dp)
           .clip(RoundedCornerShape(16.dp))
           .background(MaterialTheme.colorScheme.primary)
           .padding(16.dp)


    ){
        Column{
            Text(text = item.title,
                color = Color.White,
                fontSize = 20.sp
            )
            Text(text = item.description,
                color = Color.LightGray,
                fontSize = 12.sp
            )

        }
    }
}