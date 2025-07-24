package eo.brikoellababelo.ui.content

import androidx.appcompat.app.AppCompatDelegate.setApplicationLocales
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat.forLanguageTags
import eo.brikoellababelo.R

@Composable
fun Greeting(name: String) {
    Row {
        Text(
            modifier = Modifier.padding(start = 50.dp),
            text = name
        )
    }
}

@ExperimentalMaterial3Api
@Composable
fun LocaleDropdownMenu() {
    val localeOptions = mapOf(
        R.string.en_name to stringResource(id = R.string.en_code),
        R.string.eo_name to stringResource(id = R.string.eo_code),
        R.string.fi_name to stringResource(id = R.string.fi_code),
        R.string.fr_name to stringResource(id = R.string.fr_code),
        R.string.uk_name to stringResource(id = R.string.uk_code),
        R.string.zh_Hans_name to stringResource(id = R.string.zh_Hans_code),
        R.string.zh_Hant_name to stringResource(id = R.string.zh_Hant_code)
    ).mapKeys { stringResource(it.key) }
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        TextField(modifier = Modifier.menuAnchor(),
            readOnly = true,
            value = stringResource(R.string.language),
            onValueChange = { },
            trailingIcon = { TrailingIcon(expanded = expanded) })
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            localeOptions.keys.forEach { selectionLocale ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        setApplicationLocales(forLanguageTags(localeOptions[selectionLocale]))
                    },
                    text = { Text(selectionLocale) }
                )
            }
        }
    }
}