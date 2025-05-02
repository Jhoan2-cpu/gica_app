package com.example.gicaappandroid.ui.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffoldTemplate(
    selectedItem: String,
    drawerState: MutableState<Boolean>,
    onItemSelected: (String) -> Unit = {},
    scrollBehavior: TopAppBarScrollBehavior,
    listState: LazyListState = rememberLazyListState(),
    navController: androidx.navigation.NavController,
    content: LazyListScope.() -> Unit
) {
    Scaffold (
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            HomeHeader(onMenuClick = { drawerState.value = true }, scrollBehavior)
        },
        bottomBar = {
            BottomNavigationBar(
                selectedItem = selectedItem,
                onItemSelected = onItemSelected,
                navController = navController // Se pasa el navController
            )
        }
    ) { paddingValues ->
        LazyColumn (
            state = listState,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            content(this) //AQUÍ ESTÁ EL PROBLEMA
        }
    }
}
