package io.yeti.diablotracker.data.entity

import androidx.room.TypeConverter
import com.google.gson.Gson
import io.yeti.diablotracker.domain.models.Runes


class Converters {

    @TypeConverter
    fun listToJson(value: List<Runes>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<Runes>::class.java).toList()
}
