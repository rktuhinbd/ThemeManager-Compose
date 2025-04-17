package com.rktuhinbd.thememanager.ui.theme

import androidx.compose.ui.graphics.Color

data class SegmentColors(
    val primary: Color,
    val primaryDark: Color,
    val background: Color,
    val text: Color,
)

val GreenThemeLight = SegmentColors(
    primary = Color(0xFF1CAB55),
    primaryDark = Color(0xFF0E7B4F),
    background = Color.White,
    text = Color(0xFF111827)
)

val GreenThemeDark = SegmentColors(
    primary = Color(0xFF72E589),
    primaryDark = Color(0xFFA4F6AC),
    background = Color(0xFF111827),
    text = Color(0xFFF3F4F6)
)

val PurpleThemeLight = SegmentColors(
    primary = Color(0xFFA855F7),
    primaryDark = Color(0xFF7E22CE),
    background = Color.White,
    text = Color(0xFF111827)
)

val PurpleThemeDark = SegmentColors(
    primary = Color(0xFFD8B4FE),
    primaryDark = Color(0xFFE9D5FF),
    background = Color(0xFF111827),
    text = Color(0xFFF3F4F6)
)

val OrangeThemeLight = SegmentColors(
    primary = Color(0xFFF97316),
    primaryDark = Color(0xFFEA580C),
    background = Color.White,
    text = Color(0xFF111827)
)

val OrangeThemeDark = SegmentColors(
    primary = Color(0xFFFDBA74),
    primaryDark = Color(0xFFFFEDD5),
    background = Color(0xFF111827),
    text = Color(0xFFF3F4F6)
)
