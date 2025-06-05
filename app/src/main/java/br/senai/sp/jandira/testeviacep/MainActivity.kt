package br.senai.sp.jandira.testeviacep



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.senai.sp.jandira.testeviacep.screens.TelaCep
import br.senai.sp.jandira.testeviacep.ui.theme.TesteviacepTheme
import java.lang.reflect.Modifier


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TelaCep()
        }
    }
}


