package com.cha1se.presentation.screens

import android.app.Application
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.cha1se.domain.model.CatBreed
import com.cha1se.domain.model.Image
import com.cha1se.presentation.R
import com.cha1se.presentation.theme.Card
import com.cha1se.presentation.theme.OnSurface
import com.cha1se.presentation.theme.Primary
import com.cha1se.presentation.theme.Secondary
import com.cha1se.presentation.theme.SecondaryContainer
import com.cha1se.presentation.theme.Typography
import com.cha1se.presentation.viewmodels.ProvideMainViewModel
import com.cha1se.presentation.viewmodels.events.MainEvent
import com.cha1se.presentation.viewmodels.state.UiState

@Composable
fun MainScreen(navController: NavController) {
    val vm =
        ((LocalContext.current.applicationContext as Application) as ProvideMainViewModel).viewModel()
    val state by vm.state.collectAsState()
    val uiState by vm.uiState.collectAsState()

    LaunchedEffect(Unit) { vm.onEvent(MainEvent.loadData) }

    UiStateWrapper(uiState) {
        if (state.catList.isNotEmpty()) {
            LazyColumn(
                Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .padding(horizontal = 16.dp),
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                item {
                    Spacer(Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(text = stringResource(R.string.cat_breeds), style = Typography.titleLarge)
//                        Icon(rememberAsyncImagePainter(R.drawable.ic_search), tint = OnSurface, contentDescription = null, modifier = Modifier.size(32.dp).clip(
//                            CircleShape).clickable {
//
//                        })
                    }
                    Spacer(Modifier.height(10.dp))
                }
                itemsIndexed(state.catList) { index, cat ->
                    val smallCorner = 3.dp
                    val bigCorner = 15.dp

                    val startShape = RoundedCornerShape(
                        topStart = bigCorner,
                        topEnd = bigCorner,
                        bottomStart = smallCorner,
                        bottomEnd = smallCorner
                    )
                    val middleShape = RoundedCornerShape(
                        topStart = smallCorner,
                        topEnd = smallCorner,
                        bottomStart = smallCorner,
                        bottomEnd = smallCorner
                    )
                    val endShape = RoundedCornerShape(
                        topStart = smallCorner,
                        topEnd = smallCorner,
                        bottomStart = bigCorner,
                        bottomEnd = bigCorner
                    )

                    CatCard(
                        modifier = Modifier.clip(if (index == 0) startShape else if (index == state.catList.lastIndex) endShape else middleShape),
                        catBreed = cat
                    )
                }

                item {
                    Spacer(Modifier.navigationBarsPadding())
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
    val animateAlpha = remember { Animatable(0f) }
    LaunchedEffect(Unit) { animateAlpha.animateTo(1f) }
    Box(
        modifier = modifier
            .alpha(animateAlpha.value)
            .fillMaxWidth()
            .background(Card)
            .padding(8.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            AsyncImage(
                model = catBreed.image.url,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(height = 100.dp, width = 120.dp)
                    .clip(
                        RoundedCornerShape(12.dp)
                    )
            )
            Spacer(Modifier.width(10.dp))
            Column {
                Text(text = catBreed.name, style = Typography.labelLarge)
                Spacer(Modifier.height(3.dp))
                Text(
                    text = catBreed.description,
                    style = Typography.bodySmall,
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
//                Spacer(Modifier.height(3.dp))
//                Text(
//                    text = catBreed.temperament,
//                    style = Typography.bodyMedium,
//                    maxLines = 1,
//                    overflow = TextOverflow.Ellipsis
//                )

            }

        }
    }
}

@Composable
inline fun UiStateWrapper(uiState: UiState, ui: @Composable () -> Unit) {
    when {
        uiState.isLoading -> {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Primary)
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