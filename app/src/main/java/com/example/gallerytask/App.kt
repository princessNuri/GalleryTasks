package com.example.gallerytask

import android.app.Application
import android.content.Context
import com.example.gallerytask.di.AppModule
import toothpick.Toothpick

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        opensScope()
    }

    override fun onTerminate() {
        super.onTerminate()
        closesScope()
    }

    private fun closesScope() {
        Toothpick.closeScope(this)
    }

    private fun opensScope() {
        val scope = Toothpick.openScope(this)

        val appModule = AppModule(scope.getInstance(Context::class.java))
        scope.installModules(appModule)
    }
}