package com.baoiaminnovations.baoiamapp.authenticationfeature.presentation.components

import android.content.res.Resources
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.baoiaminnovations.baoiamapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordTextField(
    password: MutableState<String>,
    visibility: MutableState<Boolean>,
    id: Int
) {
    OutlinedTextField(
        value = password.value,
        onValueChange = { password.value = it },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            focusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer,
            unfocusedBorderColor = MaterialTheme.colorScheme.onPrimaryContainer
        ),
        label = {
            Text(
                text = stringResource(id = id),
                color = Color.Gray
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp),
        trailingIcon = {
            IconButton(onClick = { visibility.value = !visibility.value }) {
                Icon(
                    imageVector = if (visibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                    contentDescription = "visibility"
                )
            }
        },
        visualTransformation = if (visibility.value) PasswordVisualTransformation() else VisualTransformation.None
    )

}