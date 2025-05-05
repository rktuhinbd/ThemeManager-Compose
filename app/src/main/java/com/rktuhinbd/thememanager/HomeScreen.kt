package com.rktuhinbd.thememanager

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rktuhinbd.thememanager.ui.theme.AppTheme
import com.rktuhinbd.thememanager.ui.theme.LocalSegmentColors
import com.rktuhinbd.thememanager.ui.theme.ThemeManager

@Composable
fun HomeScreen(
    darkMode: Boolean,
    segment: HeroSegment,
    onThemeChange: (Boolean, HeroSegment) -> Unit
) {
    val haptic = LocalHapticFeedback.current

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

        Text("Your Hero: ${segment.value}", color = segmentColors.text)

        Spacer(Modifier.height(20.dp))

        Image(
            modifier = Modifier.size(256.dp),
            painter = painterResource(
                if (segment.value == "Captain America") {
                    R.drawable.logo_captain_america
                } else if (segment.value == "Hulk") {
                    R.drawable.logo_hulk
                } else {
                    R.drawable.logo_iron_man
                }
            ),
            contentScale = ContentScale.Inside,
            contentDescription = segment.value
        )

        Text("Current Mode: ${if (switchChecked) "Dark" else "Light"}", color = segmentColors.text)

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Dark Mode", color = segmentColors.text)

            Spacer(modifier = Modifier.width(8.dp))

            Switch(
                checked = switchChecked,
                onCheckedChange = {
                    haptic.performHapticFeedback(HapticFeedbackType.LongPress)
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

        HorizontalDivider(Modifier.fillMaxWidth(), 1.dp, Color.LightGray)

        Spacer(Modifier.height(20.dp))

        Button(onClick = { onThemeChange(darkMode, HeroSegment.IRON_MAN) }) {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            Text("Iron Man", color = segmentColors.text)
        }

        Button(onClick = { onThemeChange(darkMode, HeroSegment.CAPTAIN_AMERICA) }) {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            Text("Captain America", color = segmentColors.text)
        }

        Button(onClick = { onThemeChange(darkMode, HeroSegment.HULK) }) {
            haptic.performHapticFeedback(HapticFeedbackType.LongPress)
            Text("Hulk", color = segmentColors.text)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenPreview() {

    val context = LocalContext.current

    AppTheme(darkTheme = true, segment = HeroSegment.IRON_MAN) {
        HomeScreen(
            darkMode = true,
            segment = HeroSegment.IRON_MAN,
            onThemeChange = { newDark, newSegment ->
                ThemeManager.saveTheme(context, newDark, newSegment)
            }
        )
    }
}