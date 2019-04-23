package com.nomensvyat.github.archtest.core.di

import com.nomensvyat.github.archtest.core.utils.extensions.removeIfEquals
import kotlin.properties.Delegates
import kotlin.reflect.KClass

/**
 * Class for managing Dagger components
 * */
open class ComponentManager {
    private val map: MutableMap<Class<out Any>, Any> = mutableMapOf()

    /**
     * Stores Dagger generated component so it can be then retrieved by it's interface or
     * interfaces which component interface extend
     *
     * @param component Dagger generated component
     * */
    fun put(component: Any) {
        val clazz = component::class.java
        clazz.interfaces.forEach { componentInterface ->
            map[componentInterface] = component
            componentInterface.interfaces.forEach { componentExtends ->
                map[componentExtends] = component
            }
        }
    }

    fun <T : Any> get(klass: KClass<T>): T? {
        @Suppress("UNCHECKED_CAST")
        return map[klass.java] as? T?
    }

    fun <T : Any> getOrThrow(klass: KClass<T>): T {
        return get(klass) ?: throw IllegalStateException("No component for class $klass")
    }

    fun <T : Any> has(klass: KClass<T>): Boolean = map.containsKey(klass.java)

    /**
     * Removes from manager instances of [klass] and it's interfaces.
     * Passing component's parent
     * interfaces will not remove component instance from manager.
     * It will just remove mapping for [klass] to component.
     * Pass component interface to completely remove component instance from manager.
     *
     * @param klass component interface
     * */
    fun <T : Any> remove(klass: KClass<T>) {
        val javaClazz = klass.java
        val component = map.remove(javaClazz) ?: return
        javaClazz.interfaces.forEach { componentInterface ->
            map.removeIfEquals(componentInterface, component)
        }
    }


    companion object {
        var INSTANCE: ComponentManager by Delegates.notNull()
    }
}

inline fun <reified T : Any> ComponentManager.getOrThrow(): T = getOrThrow(T::class)