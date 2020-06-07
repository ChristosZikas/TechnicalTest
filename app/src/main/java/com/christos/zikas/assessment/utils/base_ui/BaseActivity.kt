package com.christos.zikas.assessment.utils.base_ui

import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        javaClass.getAnnotation(SetContentView::class.java)?.layout?.let {
            setContentView(it)
        }
    }

}