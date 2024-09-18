package com.example.eisenhowermatrix_taskmanager

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.util.Date
import java.util.Date.from

data class Task(
    var id: Int,
    var title: String,
    var description: String,
)

@RequiresApi(Build.VERSION_CODES.O)
fun getFakeTask():List<Task>{
    return listOf<Task>(
      Task(1,"Primeiro", "Testando"),
      Task(2,"Segundo", "Testando"),
      Task(3,"Terceiro", "Testando"),
      Task(4,"Quarto", "Testando")
    )
}
