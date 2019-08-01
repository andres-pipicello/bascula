package com.github.bascula.presistence

import androidx.room.TypeConverter
import com.github.bascula.Instant

class RoomConverters {
    @TypeConverter
    fun timestampToInstant(value: Long): Instant = Instant.ofEpochMilli(value)

    @TypeConverter
    fun instantToTimestamp(date: Instant): Long = date.toEpochMilli()
}