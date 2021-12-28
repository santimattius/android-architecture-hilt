package com.santimattius.template

import android.app.Application
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.santimattius.template.ui.theme.AndroidArchTemplateTheme
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MainApplication : Application()

@Composable
fun PicturesApplication(content: @Composable () -> Unit) {
    AndroidArchTemplateTheme {
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}