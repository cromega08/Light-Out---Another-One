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

import androidx.compose.ui.Alignment
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowPosition
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState
import lightout_anotherone.composeapp.generated.resources.Res
import lightout_anotherone.composeapp.generated.resources.app_name
import lightout_anotherone.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import java.awt.Dimension

fun main() = application {
    val windowState = rememberWindowState()

    windowState.position = WindowPosition(Alignment.Center)
    windowState.placement = WindowPlacement.Fullscreen
    windowState.isMinimized = false

    Window(
        onCloseRequest = ::exitApplication,
        state = windowState,
        title = stringResource(resource = Res.string.app_name),
        icon = painterResource(Res.drawable.compose_multiplatform)
    ) {
        val screenDimensions: Pair<Int, Int> = getFunctionalities().getScreenDimensions()

        window.minimumSize =
            Dimension(
                (screenDimensions.first / 2) + 50,
                (screenDimensions.second / 2) + 50
            )

        App()
    }
}