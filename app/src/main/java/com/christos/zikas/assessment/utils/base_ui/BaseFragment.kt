package com.christos.zikas.assessment.utils.base_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.christos.zikas.assessment.utils.eventbus.EventBusHandler
import com.christos.zikas.assessment.utils.eventbus.EventBusHandlerImpl
import dagger.android.support.DaggerFragment

open class BaseFragment(private val bus: EventBusHandler) :
    DaggerFragment(), EventBusHandler by bus {
    constructor() : this(EventBusHandlerImpl())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = javaClass.getAnnotation(SetContentView::class.java)?.layout
        return if (layout != null) inflater.inflate(layout, container, false)
        else super.onCreateView(inflater, container, savedInstanceState)
    }
}