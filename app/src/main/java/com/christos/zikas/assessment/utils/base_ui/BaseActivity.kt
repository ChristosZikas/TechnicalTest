package com.christos.zikas.assessment.utils.base_ui

import android.annotation.SuppressLint
import android.os.Bundle
import com.christos.zikas.assessment.utils.eventbus.RegisterBus
import dagger.android.support.DaggerAppCompatActivity
import org.greenrobot.eventbus.EventBus

@SuppressLint("Registered")
open class BaseActivity : DaggerAppCompatActivity() {

    var hasEventBus = false

    init {
        hasEventBus = javaClass.isAnnotationPresent(RegisterBus::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        javaClass.getAnnotation(SetContentView::class.java)?.layout?.let {
            setContentView(it)
        }
        if (hasEventBus) EventBus.getDefault().register(this)
    }

}