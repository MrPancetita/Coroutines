package net.iessochoa.sergiocontreras.coroutines

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Text("Hola")

}


@Preview(showBackground = true)
@Composable
fun MainPreview() {
    CoroutinesTheme {  // No te olvides esto
        MainView()
    }
}

