class Day02(fileName: String) {

    private val inputs = readInputs(fileName)

    fun calculateScore(correctStrategy: Boolean): Int {
        return inputs.sumOf { entry ->
            val rpsGame = entry.split(" ").let {
                RPSGame(it[0], it[1], correctStrategy)
            }

            rpsGame.getRPSGameScore() + rpsGame.getRPSChoiceScore()
        }
    }

    class RPSGame(
        private var playerOneSign: String,
        private var playerTwoSign: String,
        correctStrategy: Boolean,
    ) {
        init {
            playerOneSign = when (playerOneSign) {
                "A" -> ROCK
                "B" -> PAPER
                "C" -> SCISSORS
                else -> "ERROR"
            }

            if (correctStrategy) {
                playerTwoSign = when (playerTwoSign) {
                    "X" -> getLosingMove(playerOneSign)
                    "Y" -> playerOneSign
                    "Z" -> getWinningMove(playerOneSign)
                    else -> "ERROR"
                }
            } else {
                playerTwoSign = when (playerTwoSign) {
                    "X" -> ROCK
                    "Y" -> PAPER
                    "Z" -> SCISSORS
                    else -> "ERROR"
                }

            }
        }

        private fun getWinningMove(opponentMove: String): String {
            return when (opponentMove) {
                ROCK -> PAPER
                PAPER -> SCISSORS
                SCISSORS -> ROCK
                else -> "error"
            }
        }

        private fun getLosingMove(opponentMove: String): String {
            return when (opponentMove) {
                ROCK -> SCISSORS
                PAPER -> ROCK
                SCISSORS -> PAPER
                else -> "error"
            }
        }

        private val losingCombinations = listOf(ROCK_SCISSORS, SCISSORS_PAPER, PAPER_ROCK)

        fun getRPSGameScore(): Int {
            if (isDraw()) {
                return DRAW_SCORE
            }


            if (isLose()) {
                return LOSE_SCORE
            }

            return WIN_SCORE
        }

        fun getRPSChoiceScore(): Int {
            return when (playerTwoSign) {
                ROCK -> 1
                PAPER -> 2
                SCISSORS -> 3
                else -> 0
            }
        }

        private fun isDraw() = playerOneSign == playerTwoSign

        private fun isLose() =
            losingCombinations.any { it.playerOneSign == this.playerOneSign && it.playerTwoSign == this.playerTwoSign }

        companion object {
            private const val WIN_SCORE = 6
            private const val DRAW_SCORE = 3
            private const val LOSE_SCORE = 0
            private const val ROCK = "ROCK"
            private const val PAPER = "PAPER"
            private const val SCISSORS = "SCISSORS"
            private val ROCK_SCISSORS = RPSGame("A", "Z", false)
            private val SCISSORS_PAPER = RPSGame("C", "Y", false)
            private val PAPER_ROCK = RPSGame("B", "X", false)
        }
    }
}