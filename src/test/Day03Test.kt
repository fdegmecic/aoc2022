import org.junit.Test
import kotlin.test.assertEquals

class Day03Test {

    @Test
    fun `should calculate game score test`() {
        val answer = Day03("day03test").getRucksackCompartmentPrioritySum()

        assertEquals(157, answer)
    }

    @Test
    fun `should calculate game score`() {
        val answer = Day03("day03").getRucksackCompartmentPrioritySum()

        assertEquals(8123, answer)
    }

    @Test
    fun `should calculate game score with correct strategy test`() {
        val answer = Day03("day03test").getGroupCommonItemSum()

        assertEquals(70 , answer)
    }

    @Test
    fun `should calculate game with correct strategy score`() {
        val answer = Day03("day03").getGroupCommonItemSum()

        assertEquals(2620, answer)
    }
}