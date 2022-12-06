class Day03(fileName: String) {

    private val inputs = readInputs(fileName)
    private val lowerLetterValues = getLowerLetterValueMap()
    private val upperLetterValues = getUpperLetterValueMap()

    fun getRucksackCompartmentPrioritySum(): Int {
        return inputs.map { ruckSackItems ->
            val (firstRucksackPart, secondRucksackPart) = ruckSackItems.chunked(ruckSackItems.length / 2)

            firstRucksackPart to secondRucksackPart
        }.flatMap { (first, second) -> first.toSet() intersect second.toSet() }
            .sumOf { lowerLetterValues[it] ?: upperLetterValues[it]!! }
    }

    fun getGroupCommonItemSum(): Int {
        return inputs.chunked(3).map { groupRucksacks ->
            val (firstList, secondList, thirdList) = groupRucksacks
            val badge = firstList.toSet() intersect secondList.toSet() intersect thirdList.toSet()

            badge.first()
        }.sumOf { lowerLetterValues[it] ?: upperLetterValues[it]!! }
    }


    private fun getLowerLetterValueMap(): Map<Char, Int> {
        return ('a'..'z').zip(1..27).toMap()
    }

    private fun getUpperLetterValueMap(): Map<Char, Int> {
        return ('A'..'Z').zip(27..53).toMap()
    }
}