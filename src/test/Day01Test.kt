import org.junit.Test
import kotlin.test.assertEquals

class Day01Test {

    @Test
    fun `should calculate top calories test`() {
        val answer = Day01("day01test").solveDayOne(1)

        assertEquals(24000, answer)
    }

    @Test
    fun `should calculate top calories`() {
        val answer = Day01("day01").solveDayOne(1)

        assertEquals(24000, answer)
    }

    @Test
    fun `should calculate top three calories test`() {
        val answer = Day01("day01").solveDayOne(3)

        assertEquals(45000, answer)
    }

    @Test
    fun `should calculate top three calories`() {
        val answer = Day01("day01").solveDayOne(3)

        assertEquals(207968, answer)
    }
}