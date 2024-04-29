package com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OtpTextFields(number: MutableState<String>, labelTextId: Int) {
    OutlinedTextField(
        value = number.value,
        onValueChange = { number.value = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onSecondaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        label = {
            Text(
                text = stringResource(id = labelTextId),
                color = Color.Gray,
                textAlign = TextAlign.Center
            )
        },
        modifier = Modifier.width(50.dp),
    )
}