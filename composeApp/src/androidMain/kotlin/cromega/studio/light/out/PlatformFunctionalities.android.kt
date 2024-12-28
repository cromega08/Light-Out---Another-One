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

import android.content.res.Resources
import androidx.compose.runtime.Composable
import cromega.studio.light.out.utils.enums.Platforms
import cromega.studio.light.out.utils.interfaces.Functionalities

class AndroidFunctionalities : Functionalities
{
    override val platform: Platforms = Platforms.ANDROID

    override fun getScreenDimensions(): Pair<Int, Int>
    {
        val displayMetrics = Resources.getSystem().displayMetrics
        return Pair(displayMetrics.widthPixels, displayMetrics.heightPixels)
    }

    @Composable
    override fun getWindowDimensions(): Pair<Int, Int> = getScreenDimensions()
}

actual fun getFunctionalities(): Functionalities = AndroidFunctionalities()