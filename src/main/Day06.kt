class Day06(fileName: String) {

    private val input = readInputsAsString(fileName)

    fun getStartOfPacketMarkerPosition(window: Int): Int {
        return input.withIndex().windowed(window, 1).first { section ->
            section.map { it.value }.toSet().size == window
        }.last().index + 1
    }
}

fun main() {
    check(Day06("day06test").getStartOfPacketMarkerPosition(4) == 7)
    check(Day06("day06").getStartOfPacketMarkerPosition(4) == 1855)
    check(Day06("day06test").getStartOfPacketMarkerPosition(14) == 19)
    check(Day06("day06").getStartOfPacketMarkerPosition(14) == 3256)
}