package net.iessochoa.sergiocontreras.coroutines

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import net.iessochoa.sergiocontreras.coroutines.ui.theme.CoroutinesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoroutinesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    var result by remember { mutableLongStateOf(0) }
                    var inProgress by remember { mutableStateOf(false) }


                    MainView(modifier = Modifier
                        .fillMaxWidth()
                        .padding(innerPadding),
                        inProgress = inProgress,
                        result = result,
                        onClick = { number ->
                            inProgress = true
                            startFib(number) { response ->
                                result = response
                                inProgress = false
                            }
                        }
                        ) //Aquí también
                }
            }
        }
    }

    private fun startFib(number: Long, onResult: (Long) -> Unit) {
        CoroutineScope(Job()).launch {
            val fib = fibonacci(number)
            onResult(fib)
        }

    }

    private fun fibonacci(n: Long): Long {
        return if (n <= 1) n
        else fibonacci(n - 1) + fibonacci(n - 2)
    }
}


//Sustituimos
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    CoroutinesTheme {
        MainPreview()
    }
}