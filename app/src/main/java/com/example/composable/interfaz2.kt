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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Interfaz2() {
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Interfaz 2",
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
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 24.dp)
        ) {
            Text(
                "Deadline is coming!",
                fontSize = 18.sp,
                color = Color(0xFFD32F2F),
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text("!", fontSize = 24.sp, color = Color(0xFFD32F2F))
        }
        Text(
            "Learning",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        LearningCard(
            title = "Autumn Term",
            subtitle = "Week 1",
            color = Color(0xFFAB47BC),
            emoji = "🦒"
        )
        Spacer(modifier = Modifier.height(12.dp))
        // Tarjeta Try for 7 Days Day 2
        LearningCard(
            title = "Try for 7 Days",
            subtitle = "Day 2 2",
            color = Color(0xFF4FC3F7),
            emoji = "🐧"
        )
    }
}
@Composable
fun Column(modifier: padding, content: @Composable () -> Unit) {
    TODO("Not yet implemented")
}

annotation class padding

@Composable
fun CourseCard(
    title: String,
    subtitle: String,
    price: String,
    oldPrice: String,
    color: Color,
    emoji: String
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .background(Color.White.copy(alpha = 0.2f), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text(emoji, fontSize = 48.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(subtitle, fontSize = 14.sp, color = Color.White.copy(alpha = 0.8f))
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(price, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(
                    oldPrice,
                    fontSize = 14.sp,
                    color = Color.White.copy(alpha = 0.7f),
                    textDecoration = TextDecoration.LineThrough
                )
            }
        }
    }
}
@Composable
fun LearningCard(
    title: String,
    subtitle: String,
    color: Color,
    emoji: String
) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(title, fontSize = 20.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Text(subtitle, fontSize = 16.sp, color = Color.White.copy(alpha = 0.85f))
            }
            Box(
                modifier = Modifier
                    .size(70.dp)
                    .background(Color.White.copy(alpha = 0.25f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(emoji, fontSize = 48.sp)
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* sin funcionalidad */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White)
            ) {
                Text("Start", color = color, fontWeight = FontWeight.Bold)
            }
        }
    }
}