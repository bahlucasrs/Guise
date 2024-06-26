package com.houvven.guise.ui.screen.launch.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeRoute(
    coordinator: HomeCoordinator = rememberHomeCoordinator()
) {
    // State observing and declarations
    val uiState by coordinator.screenStateFlow.collectAsStateWithLifecycle(HomeState())

    // UI Actions
    val actions = rememberHomeActions(coordinator)

    // UI Rendering
    HomeScreen(uiState, actions)
}


@Composable
fun rememberHomeActions(coordinator: HomeCoordinator): HomeActions {
    return remember(coordinator) {
        coordinator.run {
            HomeActions(
                onAppQueryChange = viewModel::onAppQueryChange,
                onAppClick = ::onAppLick
            )
        }
    }
}
