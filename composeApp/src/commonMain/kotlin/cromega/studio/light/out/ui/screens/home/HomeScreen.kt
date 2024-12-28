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

package cromega.studio.light.out.ui.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import cromega.studio.light.out.ui.components.CenteredBox
import cromega.studio.light.out.ui.components.LightBox
import cromega.studio.light.out.ui.components.LightText
import cromega.studio.light.out.ui.components.NSquareGrid
import cromega.studio.light.out.ui.screens.generic.FeatureScreen

class HomeScreen(
    viewModel: HomeViewModel
) : FeatureScreen<HomeViewModel>(viewModel = viewModel)
{
    @Composable
    override fun Header() {}

    @Composable
    override fun Body(paddingValues: PaddingValues)
    {
        val items = viewModel.boardSizes.map { "$it x $it" }

        CenteredBox(
            modifier =
                Modifier
                    .fillMaxSize()
                    .background(color = Color.Black)
        ) {
            NSquareGrid(isPortrait = viewModel.functionalities.isPortrait)
            {
                items(items)
                { item ->
                    val index = items.indexOf(item)
                    val lightOn: Boolean = viewModel.lightsOn[index]

                    LightBox(
                        lightOn = lightOn,
                        onClick =
                            {
                                viewModel.setLight(index = index, on = !lightOn)
                            },
                        content = { LightText(text = item, lightOn = !lightOn) }
                    )
                }
            }
        }
    }

    @Composable
    override fun Footer() {}
}