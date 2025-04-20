package com.rktuhinbd.thememanager.ui.theme

import android.content.Context
import androidx.core.content.edit
import com.rktuhinbd.thememanager.HeroSegment

object ThemeManager {
    private const val PREFS_NAME = "theme_prefs"
    private const val KEY_DARK_MODE = "dark_mode"
    private const val KEY_SEGMENT = "segment"

    var isDarkMode: Boolean = true
    var currentSegment: HeroSegment = HeroSegment.IRON_MAN

    fun loadTheme(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        isDarkMode = prefs.getBoolean(KEY_DARK_MODE, true)
        currentSegment = when (prefs.getString(KEY_SEGMENT, HeroSegment.IRON_MAN.name)) {
            HeroSegment.CAPTAIN_AMERICA.name -> HeroSegment.CAPTAIN_AMERICA
            HeroSegment.HULK.name -> HeroSegment.HULK
            else -> HeroSegment.IRON_MAN
        }
    }

    fun saveTheme(context: Context, darkMode: Boolean, segment: HeroSegment) {
        isDarkMode = darkMode
        currentSegment = segment
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit {
            putBoolean(KEY_DARK_MODE, darkMode)
                .putString(KEY_SEGMENT, segment.name)
        }
    }
}