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

package cromega.studio.light.out.ui.navigation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

class NavigationController(
    initialScreen: Screen
) {
    private val currentScreenState: MutableState<Screen> = mutableStateOf(initialScreen)
    var currentScreen: Screen
        get() = currentScreenState.value
        set(value) { currentScreenState.value = value }

    private var lastScreen: Screen? = null

    var currentArguments: Map<String, Any> = mapOf()
        private set
    private var lastArguments: Map<String, Any> = mapOf()

    fun navigateTo(screen: Screen, arguments: Map<String, Any> = mapOf())
    {
        lastScreen = currentScreen
        currentScreen = screen
        lastArguments = currentArguments
        currentArguments = arguments
    }

    fun navigateBack()
    {
        if (lastScreen != null)
        {
            currentScreen = lastScreen!!
            lastScreen = null
            currentArguments = lastArguments
            lastArguments = mapOf()
        }
    }
}