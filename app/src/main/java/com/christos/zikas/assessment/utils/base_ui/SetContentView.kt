package com.christos.zikas.assessment.utils.base_ui

import java.lang.annotation.Inherited

@Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class SetContentView(val layout: Int)