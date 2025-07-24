package eo.brikoellababelo.ui.content

import androidx.appcompat.app.AppCompatDelegate.setApplicationLocales
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults.TrailingIcon
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat.forLanguageTags
import eo.brikoellababelo.R

@Composable
fun Greeting() {
    Text(
        modifier = Modifier.padding(start = 25.dp),
        text = stringResource(id = R.string.greeting_message),
        style = typography.headlineLarge
    )
}

@Composable
fun Picture(modifier: Modifier) {
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.picture),
        contentDescription = stringResource(id = R.string.language)
    )
}

@Composable
fun Slogan() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center,
        text = stringResource(id = R.string.slogan_message),
        style = typography.bodyLarge
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocaleDropdownMenu() {
    val localeOptions = mapOf(
        R.string.en_name to stringResource(id = R.string.en_code),
        R.string.eo_name to stringResource(id = R.string.eo_code),
        R.string.fa_name to stringResource(id = R.string.fa_code),
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
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryNotEditable, true),
            readOnly = true,
            value = stringResource(R.string.language),
            onValueChange = { },
            trailingIcon = { TrailingIcon(expanded) },
            textStyle = typography.titleLarge
        )
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
                    text = {
                        Text(
                            text = selectionLocale,
                            style = typography.bodyLarge
                        )
                    }
                )
            }
        }
    }
}