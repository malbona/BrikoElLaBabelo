package eo.brikoellababelo

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import eo.brikoellababelo.ui.content.Greeting
import eo.brikoellababelo.ui.content.LocaleDropdownMenu
import eo.brikoellababelo.ui.content.Picture
import eo.brikoellababelo.ui.content.Slogan
import eo.brikoellababelo.ui.theme.BrikoElLaBabeloTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BrikoElLaBabeloTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(Modifier.fillMaxSize()) {
                        LocaleDropdownMenu()
                        Greeting()
                        Picture(
                            Modifier
                                .weight(1.3F)
                                .fillMaxSize()
                                .padding(all = 25.dp)
                        )
                        Spacer(Modifier.weight(1F))
                        Slogan()
                    }
                }
            }
        }
    }
}
