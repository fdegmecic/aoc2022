import org.junit.Test
import kotlin.test.assertEquals

class Day02Test {

    @Test
    fun `should calculate game score test`() {
        val answer = Day02("day02test").calculateScore(correctStrategy = false)

        assertEquals(15, answer)
    }

    @Test
    fun `should calculate game score`() {
        val answer = Day02("day02").calculateScore(correctStrategy = false)

        assertEquals(11767, answer)
    }

    @Test
    fun `should calculate game score with correct strategy test`() {
        val answer = Day02("day02test").calculateScore(correctStrategy = true)

        assertEquals(12, answer)
    }

    @Test
    fun `should calculate game with correct strategy score`() {
        val answer = Day02("day02").calculateScore(correctStrategy = true)

        assertEquals(13886, answer)
    }
}