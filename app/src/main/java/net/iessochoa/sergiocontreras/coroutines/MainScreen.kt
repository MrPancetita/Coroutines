package net.iessochoa.sergiocontreras.coroutines

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import net.iessochoa.sergiocontreras.coroutines.ui.theme.CoroutinesTheme

/**
 * Project: Coroutines
 * From: net.iessochoa.sergiocontreras.coroutines
 * Created by: Contr
 * On: 16/10/2025 at 15:02
 * Creado en Settings -> Editor -> File and Code Templates
 */

@Composable
fun MainView(modifier: Modifier) {
    var inProgressValue by remember { mutableStateOf(false) }
    var resulValue by remember { mutableStateOf("") }
    var numberValue by remember {mutableStateOf("")}

    Column(modifier.padding(dimensionResource(R.dimen.common_padding_min)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Cargando otro proceso...")
        CircularProgressIndicator(
            Modifier.padding(vertical = dimensionResource(R.dimen.common_padding_default)),
            trackColor = Color.Red
        )

        OutlinedTextField (
            value = numberValue,
            onValueChange = { numberValue = it},
            modifier = modifier,
            label = { Text ("Introduzca un número")}

        )

        Button(onClick = {}) {
            Text("Calcular")
        }

        if (!inProgressValue) Text(text = "El resultado es: $resulValue", modifier = modifier)
        if (inProgressValue) CircularProgressIndicator()



    }

}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CoroutinesTheme {  // No te olvides esto
        MainView(Modifier
            .fillMaxWidth()
            .padding(top = 24.dp))
    }
}

