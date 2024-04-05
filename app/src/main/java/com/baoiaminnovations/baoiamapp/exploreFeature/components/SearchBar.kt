package com.baoiaminnovations.baoiamapp.exploreFeature.components

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.baoiaminnovations.baoiamapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(text: MutableState<String>, active: MutableState<Boolean>) {
    val context = LocalContext.current
    SearchBar(
        query = text.value,
        onQueryChange = { text.value = it },
        onSearch = {
            active.value = !active.value
            if (text.value.isNotEmpty()) {
            } else {
                Toast.makeText(context, "Nothing to search", Toast.LENGTH_SHORT).show()
            }
        },
        active = active.value,
        onActiveChange = { active.value = !active.value },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp),
        enabled = true,
        colors = SearchBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.onPrimaryContainer,
            //dividerColor = MaterialTheme.colors.primary,
            //inputFieldColors = TextFieldDefaults.colors(
        ),

        tonalElevation = SearchBarDefaults.Elevation.plus(10.dp),
        shape = MaterialTheme.shapes.medium.copy(
            topStart = CornerSize(15.dp),
            topEnd = CornerSize(15.dp),
            bottomEnd = CornerSize(15.dp),
            bottomStart = CornerSize(15.dp),
        ),
        leadingIcon = {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = stringResource(id = R.string.search),
            )
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Mic,
                    contentDescription = stringResource(id = R.string.mic),
                )
            }
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.whatDoYouWantToLearn),
                modifier = Modifier.alpha(.5f),
            )
        },
    ) {
    }
}