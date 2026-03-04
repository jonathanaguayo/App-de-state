package com.example.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Interfaz1() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Interfaz 1",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF1976D2)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Box(
                modifier = Modifier.size(48.dp).clip(CircleShape).background(Color.Magenta)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("kyzamiz", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                Text("Grade 4", fontSize = 16.sp, color = Color.Gray)
            }
        }

        Card(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF66BB6A))
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Numbers",
                    fontSize = 28.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "Hello cuddly numbers!",
                    fontSize = 18.sp,
                    color = Color.White.copy(alpha = 0.9f)
                )
                Spacer(modifier = Modifier.height(16.dp))
                // Placeholder para la rana
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.White.copy(alpha = 0.25f), CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("🐸", fontSize = 60.sp)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(
                    onClick = { /* sin funcionalidad */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Start", color = Color(0xFF388E3C), fontWeight = FontWeight.Bold)
                }
            }
        }

        Text(
            "Courses",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )

        // Tarjeta "Try for 7 Days"
        CourseCard(
            title = "Try for 7 Days",
            subtitle = "Start on Aug. 1st",
            price = "¥9.9",
            oldPrice = "¥388",
            color = Color(0xFF42A5F5),
            emoji = "🐧"
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Tarjeta "Autumn Term"
        CourseCard(
            title = "Autumn Term",
            subtitle = "Start on Sep. 1st",
            price = "¥398",
            oldPrice = "¥1200",
            color = Color(0xFFAB47BC),
            emoji = "🦒"
        )
    }
}
@Preview(showBackground = true, showSystemUi = true, name = "Interfaz 1 - Phone")
@Composable
fun Interfaz1Preview() {
    OnionMathReplicaTheme {
        Interfaz1()
    }
}

@Composable
fun OnionMathReplicaTheme(content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}