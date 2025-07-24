package eo.brikoellababelo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import eo.brikoellababelo.ui.content.Greeting
import eo.brikoellababelo.ui.theme.BrikoElLaBabeloTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val config = resources.configuration
//        val lang = "zh" // your language code
//        val locale = Locale(lang)
//        Locale.setDefault(locale)
//        config.setLocale(locale)
//        resources.updateConfiguration(config, resources.displayMetrics)
        setContent {
            BrikoElLaBabeloTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting(stringResource(id = R.string.app_name))
                }
            }
        }
    }
}
