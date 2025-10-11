package org.fossify.calendar

import org.fossify.calendar.extensions.hasDummyAlarm
import org.fossify.calendar.jobs.AppStartupWorker
import org.fossify.commons.FossifyApp
import org.fossify.commons.extensions.baseConfig

class App : FossifyApp() {
    override fun onCreate() {
        super.onCreate()
        if (!hasDummyAlarm()) {
            AppStartupWorker.start(this)
        }
        baseConfig.isSystemThemeEnabled = true
        baseConfig.isGlobalThemeEnabled = false
        baseConfig.hadThankYouInstalled = true
    }
}
