package com.example.composeandxml

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun FragmentOneView(
    onClick: (String) -> Unit
) {
    var name: String by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly

    ) {

        TextField(
            value = name,
            onValueChange = {
                name = it
            },
            placeholder = { Text(text = "Type something...") })
        Button(onClick = { onClick(name) }) {
            Text(text = "Go to Fragment Two")
        }
    }
}

@Composable
fun FragmentTwoView(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = name)
    }
}