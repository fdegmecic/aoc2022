class Day01(fileName: String) {

    private val calories = readInputsAsString(fileName)

    fun getElfSnackCalories(numberOfElves: Int): Int {
        return calories
            .trim()
            .split("\n\n")
            .map { calories -> calories.lines().sumOf { it.toInt() } }
            .sortedDescending()
            .take(numberOfElves)
            .sum()
    }
}