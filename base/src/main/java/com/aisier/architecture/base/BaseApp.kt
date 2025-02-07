package com.aisier.architecture.base

import android.app.Application
import android.util.Log
import androidx.lifecycle.*

/**
 * author : wutao
 * time   : 2019/05/17
 * desc   :
 * version: 1.0
 */
open class BaseApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationLifecycleObserver())
    }

    companion object {
        lateinit var instance: BaseApp
            private set
    }

    private inner class ApplicationLifecycleObserver : DefaultLifecycleObserver {

        override fun onStart(owner: LifecycleOwner) {
            Log.i("wutao--> ", "Application: onStart")
        }

        override fun onStop(owner: LifecycleOwner) {
            Log.i("wutao--> ", "Application: onStop")
        }
    }
}