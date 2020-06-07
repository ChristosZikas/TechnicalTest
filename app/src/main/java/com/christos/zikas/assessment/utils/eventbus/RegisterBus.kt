package com.christos.zikas.assessment.utils.eventbus

import java.lang.annotation.Inherited

@kotlin.annotation.Target(AnnotationTarget.CLASS, AnnotationTarget.FILE)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@Inherited
annotation class RegisterBus
