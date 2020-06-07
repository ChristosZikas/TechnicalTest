package com.christos.zikas.assessment.utils.base_ui

import android.os.Bundle
import android.os.PersistableBundle
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        javaClass.getAnnotation(SetContentView::class.java)?.layout?.let {
            setContentView(it)
        }
    }

}