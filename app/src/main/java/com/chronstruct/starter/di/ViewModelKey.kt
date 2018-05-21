package com.chronstruct.starter.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

// TODO: Remove and replace with https://github.com/alexfacciorusso/DaggerViewModel when it updates to androidx

/**
 * @author alexfacciorusso
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

