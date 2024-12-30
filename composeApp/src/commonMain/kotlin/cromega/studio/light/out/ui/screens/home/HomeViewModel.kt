/**
 *     <Light Out - Another One | Another implementation of the popular game of "Light Out".>
 *     Copyright (C) <2024 - 2025>  <Cromega>
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Affero General Public License as published
 *     by the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Affero General Public License for more details.
 *
 *     You should have received a copy of the GNU Affero General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

/**
 * Author: Cromega
 * E-mail: cr.jrg08@gmail.com
 */

package cromega.studio.light.out.ui.screens.home

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import cromega.studio.light.out.ui.navigation.NavigationController
import cromega.studio.light.out.ui.navigation.Screen
import cromega.studio.light.out.ui.screens.generic.FeatureViewModel

class HomeViewModel(
    navigationController: NavigationController
) : FeatureViewModel(navigationController = navigationController)
{
    val boardSizes: List<Int> = (3..6).toList()

    private val lightsOnState: SnapshotStateList<Boolean> =
        mutableStateListOf( *(boardSizes.map { false }.toTypedArray()) )
    val lightsOn: List<Boolean>
        get() = lightsOnState

    fun setLight(index: Int, on: Boolean = true)
    {
        lightsOnState[index] = on
    }

    fun startGame(selectedBoardSize: Int) =
        navigationController.navigateTo(Screen.Game, mapOf("boardSize" to selectedBoardSize))
}