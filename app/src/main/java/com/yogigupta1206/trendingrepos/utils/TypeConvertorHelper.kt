package com.yogigupta1206.trendingrepos.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yogigupta1206.trendingrepos.data.database.model.repos.BuiltBy
import java.lang.reflect.Type

class TypeConvertorHelper{
    @TypeConverter
    fun stringToBuiltByList(data: String?): List<BuiltBy>? {
        val listType: Type = object : TypeToken<ArrayList<BuiltBy?>?>() {}.type
        return Gson().fromJson(data, listType)
    }

    @TypeConverter
    fun builtByListToString(someObjects: List<BuiltBy>?): String? {
        return Gson().toJson(someObjects)
    }
}