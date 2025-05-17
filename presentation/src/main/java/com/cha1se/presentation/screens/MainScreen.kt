package com.cha1se.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.model.Image
import com.cha1se.presentation.R
import com.cha1se.presentation.theme.Primary
import com.cha1se.presentation.theme.Typography
import com.cha1se.presentation.viewmodels.MainViewModel
import com.cha1se.presentation.viewmodels.events.MainEvent
import com.cha1se.presentation.viewmodels.state.UiState

@Composable
fun MainScreen(navController: NavController) {
    val vm = viewModel<MainViewModel>()
    val state by vm.state.collectAsState()
    val uiState by vm.uiState.collectAsState()

    LaunchedEffect(Unit) { vm.onEvent(MainEvent.loadData) }

    UiStateWrapper(uiState) {
        if (state.catList.isNotEmpty()) {
            LazyColumn(Modifier
                .fillMaxWidth()
                .systemBarsPadding()
                .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)) {
                items(state.catList) { cat ->
                    CatCard(modifier = Modifier, catBreed = cat)
                }
            }
        }
    }
}

@Preview
@Composable
fun CatCard(
    modifier: Modifier = Modifier,
    catBreed: CatBreed = CatBreed(
        id = "0",
        name = "Barsik",
        description = "My name is Barsik, i like a fish",
        image = Image(id = "0", url = "https://cdn2.thecatapi.com/images/3kh.jpg"),
        temperament = "Dobriy dobriy cat"
    )
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(Primary)
            .padding(10.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = catBreed.image.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .size(height = 100.dp, width = 120.dp)
                    .clip(
                        RoundedCornerShape(10.dp)
                    )
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(text = catBreed.name, style = Typography.labelLarge)
                Text(text = catBreed.description, style = Typography.bodyLarge, maxLines = 3, overflow = TextOverflow.Ellipsis)
                Text(text = catBreed.temperament, style = Typography.bodyLarge, maxLines = 3, overflow = TextOverflow.Ellipsis)

            }

        }
    }
}

@Composable
inline fun UiStateWrapper(uiState: UiState, ui: @Composable () -> Unit) {
    when {
        uiState.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        uiState.isError -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(
                    stringResource(R.string.loading_error),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp)
                )
            }
        }

        (!uiState.isLoading && !uiState.isError) -> {
            ui()
        }

    }
}