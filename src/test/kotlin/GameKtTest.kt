import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.rmmcosta.GameOption
import org.rmmcosta.Player
import org.rmmcosta.calculateWinner

class GameKtTest {

    @Test
    fun `given the User chooses Rock, when the computer draws Rock, then no one wins`() {
        assertEquals(Player.NO_ONE, calculateWinner(GameOption.ROCK, GameOption.ROCK).whoWon)
    }

    @Test
    fun `given the User chooses Rock, when the computer draws Scissors, then the User wins`() {
        assertEquals(Player.USER, calculateWinner(GameOption.ROCK, GameOption.SCISSORS).whoWon)
    }

    @Test
    fun `given the User chooses Rock, when the computer draws Paper, then the Computer wins`() {
        assertEquals(Player.COMPUTER, calculateWinner(GameOption.ROCK, GameOption.PAPER).whoWon)
    }

    @Test
    fun `given the User chooses Paper, when the computer draws Rock, then the User wins`() {
        assertEquals(Player.USER, calculateWinner(GameOption.PAPER, GameOption.ROCK).whoWon)
    }

    @Test
    fun `given the User chooses Paper, when the computer draws Scissors, then the Computer wins`() {
        assertEquals(Player.COMPUTER, calculateWinner(GameOption.PAPER, GameOption.SCISSORS).whoWon)
    }

    @Test
    fun `given the User chooses Paper, when the computer draws Paper, then no one wins`() {
        assertEquals(Player.NO_ONE, calculateWinner(GameOption.PAPER, GameOption.PAPER).whoWon)
    }

    @Test
    fun `given the User chooses Scissors, when the computer draws Rock, then the Computer wins`() {
        assertEquals(Player.COMPUTER, calculateWinner(GameOption.SCISSORS, GameOption.ROCK).whoWon)
    }

    @Test
    fun `given the User chooses Scissors, when the computer draws Scissors, then no one wins`() {
        assertEquals(Player.NO_ONE, calculateWinner(GameOption.SCISSORS, GameOption.SCISSORS).whoWon)
    }

    @Test
    fun `given the User chooses Scissors, when the computer draws Paper, then the User wins`() {
        assertEquals(Player.USER, calculateWinner(GameOption.SCISSORS, GameOption.PAPER).whoWon)
    }
}