package com.example.gicaappandroid.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview()
@Composable
fun BottomNavigationBar(
    selectedItem: String = "Cursos",
    onItemSelected: (String) -> Unit = {}
) {
    val items = remember {
        listOf(
            BottomNavItem("Cursos", Icons.Rounded.Info),
            BottomNavItem("Reglamentos", Icons.Rounded.Warning),
            BottomNavItem("Inicio", Icons.Rounded.Home),
            BottomNavItem("Plataformas", Icons.Rounded.Lock),
            BottomNavItem("Usuario", Icons.Rounded.AccountCircle)
        )
    }

    val selectedColor = Color.White
    val unselectedColor = Color(0xFFB0BEC5)
    val selectedBackgroundColor = Color(0xFF123967)
    val unselectedBackgroundColor = Color(0xFF1B263B)

    Surface(
        modifier = Modifier.fillMaxWidth(),
        tonalElevation = 8.dp
    ) {
        Box(
            modifier = Modifier
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF406C9D),
                            Color(0xFF415A77)
                        )
                    )
                )
                .padding(vertical = 8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .navigationBarsPadding(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items.forEach { item ->
                    val isSelected = item.label == selectedItem
                    val offsetY by animateDpAsState(targetValue = if (isSelected) (-4).dp else 0.dp)

                    Column(
                        modifier = Modifier
                            .offset(y = offsetY)
                            .clickable { onItemSelected(item.label) },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .clip(CircleShape)
                                .background(
                                    if (isSelected) selectedBackgroundColor else unselectedBackgroundColor
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.label,
                                tint = if (isSelected) selectedColor else unselectedColor,
                                modifier = Modifier.size(24.dp)
                            )
                        }

                        Text(
                            text = item.label,
                            fontSize = 12.sp,
                            color = if (isSelected) selectedColor else unselectedColor
                        )
                    }
                }
            }
        }
    }
}
data class BottomNavItem(val label: String, val icon: ImageVector)