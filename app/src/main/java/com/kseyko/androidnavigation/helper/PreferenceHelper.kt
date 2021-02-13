package com.kseyko.androidnavigation.helper

import android.content.Context
import android.content.SharedPreferences


/**     Code with ❤
╔════════════════════════════╗
║   Created by Seyfi ERCAN   ║
╠════════════════════════════╣
║  seyfiercan35@hotmail.com  ║
╠════════════════════════════╣
║      13,February,2021      ║
╚════════════════════════════╝
 */
object PreferenceHelper {

    private const val name = "sharedName"
    private const val surname = "sharedUsername"


    fun customPreference(context: Context, name: String): SharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE)

    private inline fun SharedPreferences.editMe(operation: (SharedPreferences.Editor) -> Unit) {
        val editMe = edit()
        operation(editMe)
        editMe.apply()
    }

    var SharedPreferences.nameShared
        get() = getString(name, "")
        set(value) {
            editMe {
                it.putString(name, value)
            }
        }

    var SharedPreferences.surnameShared
        get() = getString(surname, "")
        set(value) {
            editMe {
                it.putString(surname, value)
            }
        }

}