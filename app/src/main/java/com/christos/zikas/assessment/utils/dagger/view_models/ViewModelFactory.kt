package com.christos.zikas.assessment.utils.dagger.view_models

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

inline fun <reified T : ViewModel> ViewModelProvider.Factory.getVM(scope: Fragment) =
    ViewModelProviders.of(scope, this).get(T::class.java)

@Singleton
class ViewModelFactory @Inject constructor(
    private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator = findCreatorClass(modelClass)
            ?: throw IllegalArgumentException("Unknown model class $modelClass. Check if you added @Provide for $modelClass and annotate it with @${IntoMap::class} and @${ViewModelKey::class}")
        return creator.get() as T
    }

    private fun <T : ViewModel> findCreatorClass(modelClass: Class<T>): @JvmSuppressWildcards Provider<ViewModel>? {
        var creator = creators[modelClass]
        if (creator == null) {
            for (entry in creators.entries) {
                if (modelClass.isAssignableFrom(entry.key)) {
                    creator = entry.value
                    break
                }
            }
        }
        return creator
    }
}