package com.rktuhinbd.thememanager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rktuhinbd.thememanager.ui.theme.LocalSegmentColors

@Composable
fun HomeScreen(
    darkMode: Boolean,
    segment: UserSegment,
    onThemeChange: (Boolean, UserSegment) -> Unit
) {
    val segmentColors = LocalSegmentColors.current
    var switchChecked by remember { mutableStateOf(darkMode) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(segmentColors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Current Mode: ${if (switchChecked) "Dark" else "Light"}", color = segmentColors.text)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode", color = segmentColors.text)

            Spacer(modifier = Modifier.width(8.dp))

            Switch(
                checked = switchChecked,
                onCheckedChange = {
                    switchChecked = it
                    onThemeChange(it, segment)
                },
                colors = SwitchDefaults.colors(
                    checkedThumbColor = segmentColors.primary,
                    checkedTrackColor = segmentColors.primary.copy(alpha = 0.5f),
                    uncheckedThumbColor = segmentColors.primaryDark,
                    uncheckedTrackColor = segmentColors.primaryDark.copy(alpha = 0.3f)
                )
            )
        }

        Spacer(Modifier.height(20.dp))

        Divider()

        Spacer(Modifier.height(20.dp))

        Text("Segment: ${segment.name}", color = segmentColors.text)

        Button(onClick = { onThemeChange(darkMode, UserSegment.K12) }) {
            Text("K12", color = segmentColors.text)
        }

        Button(onClick = { onThemeChange(darkMode, UserSegment.SKILLS) }) {
            Text("Skills", color = segmentColors.text)
        }

        Button(onClick = { onThemeChange(darkMode, UserSegment.KIDS) }) {
            Text("Kids", color = segmentColors.text)
        }
    }
}
