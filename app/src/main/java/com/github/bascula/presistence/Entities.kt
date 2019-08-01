package com.github.bascula.presistence


import androidx.room.*
import androidx.room.Database
import com.github.bascula.Instant

@Database(entities = [Measurement::class, Source::class, SourceMeasurement::class, Measure::class], version = 1)
@TypeConverters(RoomConverters::class)
abstract class Database : RoomDatabase() {
    abstract fun measurements(): MeasurementDao
}

@Entity
data class Measure(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String
)

@Entity(
    foreignKeys = [ForeignKey(
        entity = Measure::class,
        parentColumns = ["id"],
        childColumns = ["measureId"],
        onDelete = ForeignKey.SET_NULL
    )]
)
data class Measurement(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val measureId: Int,
    val sourceId: Int,
    val timestamp: Instant,
    val type: String,
    val value: Float
)

@Dao
interface MeasurementDao {
    @Insert
    fun source(source: Source): Long

    @Insert
    fun insert(source: Measurement): Long

    @Query("SELECT * FROM measurement")
    fun all(): List<Measurement>

    @Query("SELECT * FROM measurement WHERE timestamp between :from and :to")
    fun between(from: Instant, to: Instant): List<Measurement>
}

@Entity
data class Source(
    val name: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}

@Entity(
    primaryKeys = ["sourceId", "type"],
    foreignKeys = [ForeignKey(entity = Source::class, childColumns = ["sourceId"], parentColumns = ["id"])]
)
data class SourceMeasurement(
    val sourceId: Int,
    val type: String,
    val precision: Double
)


//@Relation(parentColumn = "id", entityColumn = "sourceId")
//val measurements: List<Measurement>
