package com.rktuhinbd.thememanager.ui.theme

import android.content.Context
import androidx.core.content.edit
import com.rktuhinbd.thememanager.UserSegment

object ThemeManager {
    private const val PREFS_NAME = "theme_prefs"
    private const val KEY_DARK_MODE = "dark_mode"
    private const val KEY_SEGMENT = "segment"

    var isDarkMode: Boolean = false
    var currentSegment: UserSegment = UserSegment.K12

    fun loadTheme(context: Context) {
        val prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        isDarkMode = prefs.getBoolean(KEY_DARK_MODE, false)
        currentSegment = when (prefs.getString(KEY_SEGMENT, UserSegment.K12.name)) {
            UserSegment.SKILLS.name -> UserSegment.SKILLS
            UserSegment.KIDS.name -> UserSegment.KIDS
            else -> UserSegment.K12
        }
    }

    fun saveTheme(context: Context, darkMode: Boolean, segment: UserSegment) {
        isDarkMode = darkMode
        currentSegment = segment
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit {
            putBoolean(KEY_DARK_MODE, darkMode)
                .putString(KEY_SEGMENT, segment.name)
        }
    }
}