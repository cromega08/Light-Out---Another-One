package cromega.studio.light.out.ui.screens.game

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cromega.studio.light.out.ui.components.CenteredBox
import cromega.studio.light.out.ui.components.LightBox
import cromega.studio.light.out.ui.components.LightText
import cromega.studio.light.out.ui.components.NSquareGrid
import cromega.studio.light.out.ui.screens.generic.FeatureScreen
import lightout_anotherone.composeapp.generated.resources.Res
import lightout_anotherone.composeapp.generated.resources.movements
import org.jetbrains.compose.resources.stringResource

class GameScreen(
    viewModel: GameViewModel
) : FeatureScreen<GameViewModel>(viewModel = viewModel)
{
    @Composable
    override fun Header() =
        Row(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(
                onClick = { viewModel.back() },
                content = { Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", tint = Color.White) }
            )

            LightText(text = "${viewModel.moves}")

            IconButton(
                onClick = { viewModel.regenerateBoard() },
                content = { Icon(Icons.Default.Refresh, contentDescription = "", tint = Color.White) }
            )
        }

    @Composable
    override fun Body(paddingValues: PaddingValues) =
        CenteredBox(modifier = Modifier.fillMaxSize())
        {
            NSquareGrid(
                isPortrait = viewModel.functionalities.isPortrait,
                sideSize = viewModel.boardSize
            ) {
                var index: Int = -1
                items(viewModel.flattenLightsOn)
                { lightOn ->
                    index += 1
                    val coordinates: Pair<Int, Int> =
                        viewModel.findCoordinatesOfLight(flattenIndex = index)

                    LightBox(
                        lightOn = lightOn,
                        onClick =
                            {
                                viewModel.onClickLight(coordinates = coordinates)
                                viewModel.increaseMoves()
                            }
                    )
                }
            }
        }

    @Composable
    override fun Footer() {}
}