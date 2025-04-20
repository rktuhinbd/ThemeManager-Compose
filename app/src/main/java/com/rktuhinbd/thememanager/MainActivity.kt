package com.rktuhinbd.thememanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.rktuhinbd.thememanager.ui.theme.AppTheme
import com.rktuhinbd.thememanager.ui.theme.ThemeManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ThemeManager.loadTheme(this)

        setContent {
            var darkMode by remember { mutableStateOf(ThemeManager.isDarkMode) }
            var segment by remember { mutableStateOf(ThemeManager.currentSegment) }

            AppTheme(darkTheme = darkMode, segment = segment) {
                HomeScreen(
                    darkMode = darkMode,
                    segment = segment,
                    onThemeChange = { newDark, newSegment ->
                        ThemeManager.saveTheme(this, newDark, newSegment)
                        darkMode = newDark
                        segment = newSegment
                    }
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun AppPreview() {

    val context = LocalContext.current

    var darkMode by remember { mutableStateOf(ThemeManager.isDarkMode) }
    var segment by remember { mutableStateOf(ThemeManager.currentSegment) }

    AppTheme(darkTheme = darkMode, segment = segment) {
        HomeScreen(
            darkMode = darkMode,
            segment = segment,
            onThemeChange = { newDark, newSegment ->
                ThemeManager.saveTheme(context, newDark, newSegment)
                darkMode = newDark
                segment = newSegment
            }
        )
    }
}