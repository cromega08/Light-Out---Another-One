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

package cromega.studio.light.out.ui.screens.generic

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import java.awt.Dimension

abstract class FeatureScreen<VM : FeatureViewModel>(
    protected val viewModel: VM
) {
    @Composable
    open fun Screen() =
        Scaffold(
            topBar = { Header() },
            content = { paddingValues -> Body(paddingValues = paddingValues) },
            bottomBar = { Footer() },
            backgroundColor = Color.Black
        )

    @Composable
    abstract fun Header()

    @Composable
    abstract fun Body(paddingValues: PaddingValues)

    @Composable
    abstract fun Footer()
}