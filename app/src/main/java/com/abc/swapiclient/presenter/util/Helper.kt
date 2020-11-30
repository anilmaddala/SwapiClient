package com.abc.swapiclient.presenter.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.abc.swapiclient.domain.state.State
import kotlin.reflect.KProperty1


/**
 * Helper function to build URL Map to be used by ExpandableListView
 */
fun <T> buildURLMap(
    headerText: String,
    listPropertyName: String,
    mutableLiveData: MutableLiveData<State<T>>
): LiveData<HashMap<String, List<String>>> {
    return mutableLiveData.map {
        if (it is State.Success) {
            val map = HashMap<String, List<String>>()
            val list = ArrayList<String>()
            val urlList: List<String> = readInstanceProperty(it.data as Any, listPropertyName)
            if (urlList.isNotEmpty()) {
                urlList.forEach { url ->
                    list.add(url)
                }
                map[headerText] = list
            }
            map
        } else {
            HashMap()
        }
    }
}

/**
 * Get property by name as a String
 */
// Source: https://stackoverflow.com/questions/35525122/kotlin-data-class-how-to-read-the-value-of-property-if-i-dont-know-its-name-at
@Suppress("UNCHECKED_CAST")
fun <R> readInstanceProperty(instance: Any, propertyName: String): R {
    val property = instance::class.members
        // don't cast here to <Any, R>, it would succeed silently
        .first { it.name == propertyName } as KProperty1<Any, *>
    // force a invalid cast exception if incorrect type here
    return property.get(instance) as R
}