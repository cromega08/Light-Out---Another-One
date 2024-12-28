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

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import cromega.studio.light.out.utils.enums.Platforms
import cromega.studio.light.out.utils.interfaces.Functionalities
import java.awt.Dimension
import java.awt.Toolkit

class JVMFunctionalities : Functionalities
{
    override val platform: Platforms = Platforms.DESKTOP

    override fun getScreenDimensions(): Pair<Int, Int>
    {
        val screenSize: Dimension = Toolkit.getDefaultToolkit().screenSize
        return Pair(screenSize.width, screenSize.height)
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    override fun getWindowDimensions(): Pair<Int, Int>
    {
        val windowInfo = LocalWindowInfo.current
        val width = windowInfo.containerSize.width
        val height = windowInfo.containerSize.height

        return Pair(width, height)
    }
}

actual fun getFunctionalities(): Functionalities = JVMFunctionalities()