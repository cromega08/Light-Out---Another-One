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

package cromega.studio.light.out.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LightText(
    text: String,
    lightOn: Boolean = true
) =
    Text(
        text = text,
        color =
            if (lightOn) Color.White
            else Color.Black
    )
