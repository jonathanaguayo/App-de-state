package com.example.composable

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = Color.White) {
                OnionMathScreen()
            }
        }
    }
}

// Modelo de datos para los cursos
data class Course(
    val title: String,
    val date: String,
    val price: String,
    val oldPrice: String,
    val color: Color
)

@Composable
fun OnionMathScreen() {
    val courses = listOf(
        Course("Try for 7 Days", "Start on Aug. 1st", "¥9.9", "¥98", Color(0xFFE1F5FE)),
        Course("Autumn Term", "Start on Sep. 1st", "¥398", "¥1288", Color(0xFFF3E5F5))
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Spacer(modifier = Modifier.height(16.dp)) }

        // 1. HEADER
        item { HeaderSection() }

        // 2. SECCIÓN "START"
        item { SectionTitle("Start") }
        item { MainBanner() }

        // 3. SECCIÓN "COURSES"
        item { SectionTitle("Courses") }

        items(courses) { course ->
            CourseItem(course)
        }

        item { Spacer(modifier = Modifier.height(20.dp)) }
    }
}

@Composable
fun HeaderSection() {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Avatar (Placeholder rosa)
        Box(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Color(0xFFFFC1CC)),
            contentAlignment = Alignment.Center
        ) {
            Text("🐱", fontSize = 24.sp) // Sustituir por Image()
        }

        Column(modifier = Modifier.padding(start = 12.dp).weight(1f)) {
            Text(text = "kyzamiz", fontWeight = FontWeight.ExtraBold, fontSize = 18.sp)
            Text(text = "Grade 4", color = Color.Gray, fontSize = 14.sp)
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(Icon.Outlined.LibraryBooks, contentDescription = null, tint = Color.Gray, modifier = Modifier.size(18.dp))
            Text(text = "Grade", modifier = Modifier.padding(start = 4.dp), color = Color.Gray, fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun SectionTitle(title: String) {
    Text(
        text = title,
        style = MaterialTheme.typography.titleLarge,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 8.dp)
    )
}

@Composable
fun MainBanner() {
    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF86D34B)),
        modifier = Modifier.fillMaxWidth().height(180.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
            Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                Text("Numbers", color = Color.White, fontSize = 28.sp, fontWeight = FontWeight.ExtraBold)
                Text("Hello cuddly numbers!", color = Color.White.copy(alpha = 0.9f))

                Spacer(modifier = Modifier.height(12.dp))

                Button(
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp),
                    modifier = Modifier.height(36.dp)
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = null, tint = Color(0xFF86D34B), modifier = Modifier.size(16.dp))
                    Text("Start", color = Color(0xFF86D34B), fontWeight = FontWeight.Bold)
                }
            }

            // Personaje (Sustituir con tu imagen de sapito)
            Text(
                text = "🐸",
                fontSize = 80.sp,
                modifier = Modifier.align(Alignment.BottomEnd).offset(x = 10.dp, y = 10.dp)
            )
        }
    }
}

@Composable
fun CourseItem(course: Course) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del curso
        Box(
            modifier = Modifier
                .size(85.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(course.color),
            contentAlignment = Alignment.Center
        ) {
            Text("🐧", fontSize = 40.sp) // Sustituir por Image()
        }

        Column(modifier = Modifier.padding(start = 16.dp).weight(1f)) {
            Text(text = course.title, fontWeight = FontWeight.Bold, fontSize = 16.sp)
            Text(text = course.date, color = Color.Gray, fontSize = 13.sp)
        }

        Column(horizontalAlignment = Alignment.End) {
            Text(text = course.price, color = Color(0xFFFF5252), fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Text(
                text = course.oldPrice,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall.copy(textDecoration = TextDecoration.LineThrough)
            )
        }
    }
}