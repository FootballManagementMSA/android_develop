package com.example.core.di

import android.content.Context
import android.os.Build
import android.view.WindowManager
import com.example.core.model.Screen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalSizeModule {

    @Provides
    @Singleton
    fun provideLocalScreenSize(@ApplicationContext context: Context) : Screen {
        val manager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val (w, h) = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            manager.currentWindowMetrics.bounds.width() to manager.currentWindowMetrics.bounds.height()
        } else {
            manager.defaultDisplay.width to manager.defaultDisplay.height
        }
        return Screen(w.toDouble(), h.toDouble())
    }
}