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
 * Autor: Cromega
 * E-mail: cr.jrg08@gmail.com
 */

package cromega.studio.light.out

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import cromega.studio.light.out.ui.navigation.NavigationController
import cromega.studio.light.out.ui.navigation.Screen
import cromega.studio.light.out.ui.screens.game.GameScreen
import cromega.studio.light.out.ui.screens.game.GameViewModel
import cromega.studio.light.out.ui.screens.home.HomeScreen
import cromega.studio.light.out.ui.screens.home.HomeViewModel

@Composable
fun App() {
    MaterialTheme {
        val navigationController: NavigationController = remember { NavigationController(Screen.Home) }

        when(navigationController.currentScreen)
        {
            Screen.Home ->
                {
                    val home: HomeScreen = HomeScreen(viewModel = HomeViewModel(navigationController = navigationController))
                    home.Screen()
                }
            Screen.Game ->
                {
                    val game: GameScreen = GameScreen(viewModel = GameViewModel(navigationController = navigationController))

                    game.Screen()
                }
        }
    }
}