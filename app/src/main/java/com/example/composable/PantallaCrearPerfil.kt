package com.example.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicati.R

// Colores de la app
val VerdeNino = Color(0xFF8BC34A)
val RosaNina = Color(0xFFF48FB1)
val AzulIcono = Color(0xFF03A9F4)

@Composable
fun PantallaCrearPerfil() {
    var generoSeleccionado by remember { mutableStateOf("Niño") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "Regresar",
                tint = AzulIcono,
                modifier = Modifier
                    .size(28.dp)
                    .clickable { /* TODO: navegación atrás */ }
            )

            Text(
                text = "Crear Perfil",
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )

            Spacer(modifier = Modifier.width(28.dp))
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BotonGenero(
                texto = "Niño",
                colorFondo = VerdeNino,
                idImagenIcono = R.drawable.ic_nino,
                estaSeleccionado = generoSeleccionado == "Niño",
                alHacerClick = { generoSeleccionado = "Niño" },
                modifier = Modifier.weight(1f)
            )

            BotonGenero(
                texto = "Niña",
                colorFondo = RosaNina,
                idImagenIcono = R.drawable.ic_nina,
                estaSeleccionado = generoSeleccionado == "Niña",
                alHacerClick = { generoSeleccionado = "Niña" },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(64.dp))

        Image(
            painter = painterResource(id = R.drawable.fondoimagen),
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f, fill = false)
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Composable
fun BotonGenero(
    texto: String,
    colorFondo: Color,
    idImagenIcono: Int,
    estaSeleccionado: Boolean,
    alHacerClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier
            .height(68.dp)
            .clip(RoundedCornerShape(34.dp))
            .clickable(onClick = alHacerClick),
        color = colorFondo,
        tonalElevation = if (estaSeleccionado) 8.dp else 2.dp,
        shadowElevation = if (estaSeleccionado) 6.dp else 2.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = idImagenIcono),
                    contentDescription = "Ícono de $texto",
                    modifier = Modifier.size(38.dp)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    text = texto,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 19.sp
                )
            }


            if (estaSeleccionado) {
                Icon(
                    imageVector = Icons.Default.CheckCircle,
                    contentDescription = "Género seleccionado",
                    tint = Color.White,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .size(34.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPantallaCrearPerfil() {
    PantallaCrearPerfil()
}