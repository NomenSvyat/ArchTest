package com.nomensvyat.github.archtest.core.di

import kotlin.properties.Delegates
import kotlin.reflect.KClass

abstract class ComponentManager {
    private val map: MutableMap<Class<out Any>, Any> = mutableMapOf()

    fun put(component: Any) {
        val clazz = component::class.java
        clazz.interfaces.forEach { componentInterface ->
            map[componentInterface] = component
            componentInterface.interfaces.forEach { componentExtends ->
                map[componentExtends] = component
            }
        }
    }

    fun <T : Any> get(clazz: KClass<T>): T? {
        @Suppress("UNCHECKED_CAST")
        return map[clazz.java] as? T?
    }

    fun <T : Any> getOrThrow(clazz: KClass<T>): T {
        return get(clazz) ?: throw IllegalStateException("No component for class $clazz")
    }

    fun <T : Any> has(clazz: KClass<T>): Boolean = map.containsKey(clazz.java)

    fun <T : Any> remove(clazz: KClass<T>) {
        // TODO remove all interfaces
        map.remove(clazz.java)
    }

    companion object {
        var INSTANCE: ComponentManager by Delegates.notNull()
    }
}