package cromega.studio.light.out.ui.screens.game

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import cromega.studio.light.out.ui.navigation.NavigationController
import cromega.studio.light.out.ui.screens.generic.FeatureViewModel
import java.util.LinkedList
import java.util.Queue
import kotlin.properties.Delegates
import kotlin.random.Random

class GameViewModel(
    navigationController: NavigationController
) : FeatureViewModel(navigationController = navigationController)
{
    val boardSize: Int = arguments["boardSize"] as Int

    private val lightsOnState: Array<SnapshotStateList<Boolean>> =
        Array(boardSize)
        {
            mutableStateListOf( *(Array(boardSize) { Random.nextBoolean() }) )
        }
    val lightsOn: Array<Array<Boolean>>
        get() = lightsOnState.map { it.toTypedArray() }.toTypedArray()
    val flattenLightsOn: Array<Boolean>
        get() = lightsOn.flatten().toTypedArray()

    private val movesState: MutableState<Int> = mutableStateOf(0)
    var moves: Int = 0
        get() = movesState.value
        private set

    fun increaseMoves()
    {
        movesState.value += 1
    }

    fun findCoordinatesOfLight(flattenIndex: Int): Pair<Int, Int>
    {
        var position: Int = -1
        var y: Int = -1
        var x: Int

        for (element in lightsOn)
        {
            y += 1
            x = -1

            for (secondIndex in element)
            {
                x += 1
                position += 1

                if (position == flattenIndex) return y to x
            }
        }

        throw IllegalArgumentException("flattenIndex argument doesn't exist")
    }

    fun getLightAt(coordinates: Pair<Int, Int>): Boolean =
        lightsOnState[coordinates.first][coordinates.second]

    fun onClickLight(coordinates: Pair<Int, Int>)
    {
        updateLightAt(coordinates = coordinates, lightOn = !getLightAt(coordinates = coordinates))
        updateLightsToLeftAndRight(coordinates = coordinates)
        updateLightsToAboveAndBelow(coordinates = coordinates)

        if (validateVictory())
        {
            back()
        }
    }

    private fun updateLightAt(coordinates: Pair<Int, Int>, lightOn: Boolean = true)
    {
        lightsOnState[coordinates.first][coordinates.second] = lightOn
    }

    private fun updateLightsToLeftAndRight(coordinates: Pair<Int, Int>)
    {
        val absoluteCoordinate: Int = coordinates.first
        val variableCoordinate: Int = coordinates.second

        // check element at left
        if ((variableCoordinate - 1) >= 0)
        {
            val currentCoordinates: Pair<Int, Int> = absoluteCoordinate to (variableCoordinate - 1)
            val lightOn: Boolean = getLightAt(coordinates = currentCoordinates)

            updateLightAt(coordinates = currentCoordinates, lightOn = !lightOn)
        }

        // check element at right
        if ((variableCoordinate + 1) <= (boardSize - 1))
        {
            val currentCoordinates: Pair<Int, Int> = absoluteCoordinate to (variableCoordinate + 1)
            val lightOn: Boolean = getLightAt(coordinates = currentCoordinates)

            updateLightAt(coordinates = currentCoordinates, lightOn = !lightOn)
        }
    }

    private fun updateLightsToAboveAndBelow(coordinates: Pair<Int, Int>)
    {
        val absoluteCoordinate: Int = coordinates.second
        val variableCoordinate: Int = coordinates.first

        // check element above
        if ((variableCoordinate - 1) >= 0)
        {
            val currentCoordinates: Pair<Int, Int> = (variableCoordinate - 1) to absoluteCoordinate
            val lightOn: Boolean = getLightAt(coordinates = currentCoordinates)

            updateLightAt(coordinates = currentCoordinates, lightOn = !lightOn)
        }

        // check element below
        if ((variableCoordinate + 1) <= (boardSize - 1))
        {
            val currentCoordinates: Pair<Int, Int> = (variableCoordinate + 1) to absoluteCoordinate
            val lightOn: Boolean = getLightAt(coordinates = currentCoordinates)

            updateLightAt(coordinates = currentCoordinates, lightOn = !lightOn)
        }
    }

    private fun validateVictory() : Boolean = flattenLightsOn.all { lightOn -> !lightOn }

    fun regenerateBoard()
    {
        var y: Int = -1
        var x: Int

        for (row in lightsOnState)
        {
            y += 1
            x = -1

            for (light in row)
            {
                x += 1

                lightsOnState[y][x] = Random.nextBoolean()
            }
        }
    }

    fun back() = navigationController.navigateBack()
}