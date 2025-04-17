package com.rktuhinbd.thememanager.ui.theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.rktuhinbd.thememanager.UserSegment

val LocalSegmentColors = staticCompositionLocalOf { GreenThemeLight }

@Composable
fun AppTheme(
    darkTheme: Boolean,
    segment: UserSegment,
    content: @Composable () -> Unit
) {
    val segmentColors = when (segment) {
        UserSegment.K12 -> if (darkTheme) GreenThemeDark else GreenThemeLight
        UserSegment.SKILLS -> if (darkTheme) PurpleThemeDark else PurpleThemeLight
        UserSegment.KIDS -> if (darkTheme) OrangeThemeDark else OrangeThemeLight
    }

    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = segmentColors.primary,
            onPrimary = segmentColors.text,
            background = segmentColors.background,
            onBackground = segmentColors.text,
            surface = segmentColors.background,
            onSurface = segmentColors.text,
            secondary = segmentColors.primaryDark,
            onSecondary = segmentColors.text
        )
    } else {
        lightColorScheme(
            primary = segmentColors.primary,
            onPrimary = segmentColors.text,
            background = segmentColors.background,
            onBackground = segmentColors.text,
            surface = segmentColors.background,
            onSurface = segmentColors.text,
            secondary = segmentColors.primaryDark,
            onSecondary = segmentColors.text
        )
    }

    CompositionLocalProvider(LocalSegmentColors provides segmentColors) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography(),
            content = content
        )
    }
}
