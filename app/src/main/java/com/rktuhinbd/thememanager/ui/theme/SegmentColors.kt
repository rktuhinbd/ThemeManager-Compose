package com.rktuhinbd.thememanager.ui.theme

import androidx.compose.ui.graphics.Color

data class SegmentColors(
    val primary: Color,
    val primaryDark: Color,
    val background: Color,
    val text: Color,
)

val IronManThemeLight = SegmentColors(
    primary = Color(0xFFB71C1C),       // Deep Red
    primaryDark = Color(0xFFFFD700),   // Gold
    background = Color.White,
    text = Color(0xFF1C1C1C)           // Almost Black
)

val IronManThemeDark = SegmentColors(
    primary = Color(0xFFFFD700),       // Gold (brighter for contrast)
    primaryDark = Color(0xFFB71C1C),   // Deep Red
    background = Color(0xFF1C1C1C),    // Dark Grey/Metal
    text = Color(0xFFF5F5F5)           // Light Grey/White
)

val CaptainAmericaThemeLight = SegmentColors(
    primary = Color(0xFF0A74DA),       // Captain Blue
    primaryDark = Color(0xFFC8102E),   // Shield Red
    background = Color.White,
    text = Color(0xFF111827)           // Dark Text
)

val CaptainAmericaThemeDark = SegmentColors(
    primary = Color(0xFF68A8E8),       // Lighter Blue
    primaryDark = Color(0xFFF28B99),   // Lighter Red
    background = Color(0xFF0A0F1A),    // Deep Navy
    text = Color(0xFFF3F4F6)           // Light Text
)

val HulkThemeLight = SegmentColors(
    primary = Color(0xFF4CAF50),       // Hulk Green
    primaryDark = Color(0xFF7E57C2),   // Hulk Purple
    background = Color.White,
    text = Color(0xFF111827)           // Dark Text
)

val HulkThemeDark = SegmentColors(
    primary = Color(0xFF81C784),       // Soft Hulk Green
    primaryDark = Color(0xFFB39DDB),   // Soft Hulk Purple
    background = Color(0xFF111827),    // Dark Background
    text = Color(0xFFF3F4F6)           // Light Text
)
