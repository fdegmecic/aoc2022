class Day05(fileName: String) {

    private val inputsAsList = readInputs(fileName)

    fun getCrateStackArrangement(shouldReverseOrder: Boolean): String {
        val crates = parseCrates()
        val moves = parseMoves()
        moves.forEach { (amount, from, to) ->
            val cratesToMove = crates[from].takeLast(amount)
            repeat(amount) { crates[from].removeLast() }
            crates[to].addAll(if (shouldReverseOrder) cratesToMove else cratesToMove.reversed())
        }

        return crates.map { it.last() }.joinToString("")
    }

    private fun parseMoves(): List<CraneInstruction> {
        return inputsAsList.filter { it.contains("move") }.map { move ->
            move.split(" ")
                .filter { Regex("[0-9]").containsMatchIn(it) }
                .map { it.toInt() }
                .let { (amountOfCrates, from, to) ->
                    CraneInstruction(amountOfCrates, from - 1, to - 1)
                }
        }
    }

    private fun parseCrates(): List<MutableList<Char>> {
        val rows = inputsAsList.takeWhile { it.contains("[") }
        val longestRowLength = rows.last().length

        return rows.map { row ->
            val padRow = padRow(longestRowLength, row)
            getRowAsCharArray(padRow)
        }.run { transposeCharArray(this) }
            .map { row -> filterOutCharacters(row).reversed().toMutableList() }
            .filter { it.isNotEmpty() }
    }

    private fun filterOutCharacters(row: CharArray) = row.filterNot { it == '[' || it == ']' || it == ' ' }

    private fun getRowAsCharArray(padRow: String): MutableList<Char> {
        val rowAsCharArray = mutableListOf<Char>()
        repeat(padRow.length) { index ->
            rowAsCharArray += padRow.toCharArray()[index]
        }

        return rowAsCharArray
    }

    private fun transposeCharArray(paddedRows: List<MutableList<Char>>): Array<CharArray> {
        val column = paddedRows[0].size
        val row = paddedRows.size
        val transpose = Array(column) { CharArray(row) }
        for (i in 0 until row) {
            for (j in 0 until column) {
                transpose[j][i] = paddedRows[i][j]
            }
        }
        return transpose
    }

    private fun padRow(xRowLength: Int, row: String): String {
        val paddingSize = xRowLength - row.length
        val sb = StringBuilder(xRowLength)
        sb.append(row)
        for (i in 1..paddingSize) {
            sb.append(' ')
        }
        return sb.toString()
    }

    data class CraneInstruction(val amountOfCrates: Int, val from: Int, val To: Int)
}

fun main() {
    check(Day05("day05test").getCrateStackArrangement(false) == "CMZ")
    check(Day05("day05").getCrateStackArrangement(false) == "JCMHLVGMG")
    check(Day05("day05test").getCrateStackArrangement(true) == "MCD")
    check(Day05("day05").getCrateStackArrangement(true) == "LVMRWSSPZ")
}