package com.github.bascula


interface Unit{
    companion object {
        fun percentageOf(measure: Measure) = object : Unit{}
    }
}
interface Measure

enum class StandardUnit : Unit{
    KG;
}

enum class StandardMeasure : Measure {
    WEIGHT,
    FAT,
    BONE
}

data class Measurement(
    val measure: Measure,
    val value: Float,
    val unit: Unit
)