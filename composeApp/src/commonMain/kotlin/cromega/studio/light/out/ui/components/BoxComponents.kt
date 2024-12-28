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

package cromega.studio.light.out.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CenteredBox(
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)
) =
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
        content = content
    )

@Composable
fun LightBox(
    lightOn: Boolean = true,
    onClick: () -> Unit,
    content: @Composable (BoxScope.() -> Unit) = {}
) =
    CenteredBox(
        modifier =
        Modifier
            .padding(2.5.dp)
            .background(
                color =
                if (lightOn) Color.White
                else Color.DarkGray,
                shape = RoundedCornerShape(10.dp)
            )
            .aspectRatio(1f)
            .clickable(onClick = onClick)
        ,
        content = { content() }
    )
