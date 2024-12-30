package cromega.studio.light.out.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun CustomAlertDialog(
    backgroundColor: Color = Color.White,
    contentColor: Color = Color.Black,
    shape: Shape = RoundedCornerShape(10.dp),
    onDismissRequest: () -> Unit,
    confirmIcon: ImageVector,
    confirmIconDescription: String = "",
    onConfirm: () -> Unit,
    cancelIcon: ImageVector,
    cancelIconDescription: String = "",
    onCancel: () -> Unit,
    description: @Composable () -> Unit
) =
    AlertDialog(
        backgroundColor = backgroundColor,
        contentColor = contentColor,
        shape = shape,
        onDismissRequest = onDismissRequest,
        confirmButton =
            {
                IconButton(
                    modifier = Modifier.fillMaxWidth(0.48f),
                    onClick = onConfirm
                ) {
                    Icon(
                        imageVector = confirmIcon,
                        contentDescription = confirmIconDescription
                    )
                }
            },
        dismissButton =
            {
                IconButton(
                    modifier = Modifier.fillMaxWidth(0.48f),
                    onClick = onCancel
                ) {
                    Icon(
                        imageVector = cancelIcon,
                        contentDescription = cancelIconDescription
                    )
                }
            },
        text =
            {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    content = { description() }
                )
            }
    )
