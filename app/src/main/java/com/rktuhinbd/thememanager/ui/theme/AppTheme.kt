package com.rktuhinbd.thememanager.ui.theme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import com.rktuhinbd.thememanager.HeroSegment

val LocalSegmentColors = staticCompositionLocalOf { IronManThemeLight }

@Composable
fun AppTheme(
    darkTheme: Boolean,
    segment: HeroSegment,
    content: @Composable () -> Unit
) {
    val segmentColors = when (segment) {
        HeroSegment.IRON_MAN -> if (darkTheme) IronManThemeDark else IronManThemeLight
        HeroSegment.CAPTAIN_AMERICA -> if (darkTheme) CaptainAmericaThemeDark else CaptainAmericaThemeLight
        HeroSegment.HULK -> if (darkTheme) HulkThemeDark else HulkThemeLight
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
