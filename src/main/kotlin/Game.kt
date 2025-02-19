package org.rmmcosta

import kotlin.random.Random

enum class GameOption(val value: String) {
    PAPER("Paper"),
    ROCK("Rock"),
    SCISSORS("Scissors"),
    QUIT("quit")
}

enum class Player(val value: String) {
    USER("You"),
    COMPUTER("Computer"),
    NO_ONE("no one"),
    QUIT("quit")
}

fun getComputerChoice(): GameOption = GameOption.entries[Random.nextInt(0, GameOption.entries.size)]

fun getUserChoice(): GameOption {
    val prompt =
        "Please choose your option:\n${
            GameOption.entries.mapIndexed { index, gameOption -> "$index - ${gameOption.value}" }.joinToString("\n")
        }"
    var option: GameOption? = null
    while (option == null) {
        println(prompt)
        option = GameOption.entries.getOrNull(readlnOrNull()?.toIntOrNull() ?: -1)
    }
    return option
}

fun calculateWinner(userOption: GameOption, computerOption: GameOption): Winner {
    val winner =
        when (userOption) {
            GameOption.ROCK -> when (computerOption) {
                GameOption.ROCK -> Player.NO_ONE
                GameOption.SCISSORS -> Player.USER
                GameOption.PAPER -> Player.COMPUTER
                else -> Player.QUIT
            }

            GameOption.SCISSORS -> when (computerOption) {
                GameOption.ROCK -> Player.COMPUTER
                GameOption.SCISSORS -> Player.NO_ONE
                GameOption.PAPER -> Player.USER
                else -> Player.QUIT
            }

            GameOption.PAPER -> when (computerOption) {
                GameOption.ROCK -> Player.USER
                GameOption.SCISSORS -> Player.COMPUTER
                GameOption.PAPER -> Player.NO_ONE
                else -> Player.QUIT
            }

            else -> Player.QUIT
        }
    return Winner(winner, userOption, computerOption)
}

fun play() {
    var keepPlaying = true
    while (keepPlaying) {
        keepPlaying = printResult(calculateWinner(getUserChoice(), getComputerChoice()))
    }
}

data class Winner(
    val whoWon: Player,
    val userOption: GameOption,
    val computerOption: GameOption,
)

fun printResult(winner: Winner): Boolean =
    if (winner.whoWon != Player.QUIT) {
        println("${winner.whoWon.value} wins! User:${winner.userOption} vs Computer:${winner.computerOption}")
        true
    } else {
        println("You have chosen to quit the game. Bye-bye!")
        false
    }
