package eo.brikoellababelo.ui.content

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import eo.brikoellababelo.ui.theme.BrikoElLaBabeloTheme

@Composable
fun Greeting(name: String) {
    Row {
        Text(modifier = Modifier.padding(start = 50.dp), text = name)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BrikoElLaBabeloTheme {
        Greeting("Android")
    }
}