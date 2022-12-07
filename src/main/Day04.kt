class Day04(fileName: String) {

    private val inputs = readInputs(fileName)

    fun getRangeOverlaps(): Int {
        return inputs.count { ranges ->
            val (firstRangeString, secondRangeString) = ranges.split(',')

            val firstRange = getRange(firstRangeString)
            val secondRange = getRange(secondRangeString)
            val intersect = firstRange intersect secondRange.toSet()

            firstRange.all { intersect.contains(it) } || secondRange.all { intersect.contains(it) }
        }
    }

    fun getAnyOverlap(): Int {
        return inputs.count { ranges ->
            val (firstRangeString, secondRangeString) = ranges.split(',')

            val firstRange = getRange(firstRangeString)
            val secondRange = getRange(secondRangeString)
            val intersect = firstRange intersect secondRange.toSet()

            firstRange.any { intersect.contains(it) } || secondRange.any { intersect.contains(it) }
        }
    }

    private fun getRange(range: String): List<Int> {
        val (start, end) = range.split('-')

        return (start.toInt() .. end.toInt()).map { it }
    }
}

fun main() {
    check(Day04("day04test").getRangeOverlaps() == 2)
    check(Day04("day04").getRangeOverlaps() == 550)
    check(Day04("day04test").getAnyOverlap() == 4)
    check(Day04("day04").getAnyOverlap() == 931)
}