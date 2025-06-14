package com.app.recipeapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(modifier: Modifier,category: Category){
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Screen")
                },
                navigationIcon = {
                    IconButton(onClick = {
                    }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Menu")
                    }
                }
            )
        }
    ) {
        Column(modifier.padding(it), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(category.strCategory, textAlign = TextAlign.Center)
            Image(painter = rememberAsyncImagePainter(category.strCategoryThumb),
                contentDescription = "category",
                modifier = Modifier.wrapContentSize().aspectRatio(1f)
                )
            Text(category.strCategoryDescription, textAlign = TextAlign.Justify,
                modifier = Modifier.verticalScroll(rememberScrollState())
                )
        }
    }
}