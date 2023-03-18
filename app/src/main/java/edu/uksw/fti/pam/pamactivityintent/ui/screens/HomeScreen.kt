package edu.uksw.fti.pam.pamactivityintent.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import edu.uksw.fti.pam.pamactivityintent.models.AnimeViewModel
import edu.uksw.fti.pam.pamactivityintent.models.TodosViewModel
import edu.uksw.fti.pam.pamactivityintent.ui.theme.PAMActivityIntentTheme


@Composable
fun HomeScreen(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val avm = AnimeViewModel()
    PAMActivityIntentTheme {
        MainScreenView(avm)
    }
}

@Composable
fun MainScreenView(
    avm: AnimeViewModel
) {
    LaunchedEffect(
        Unit,
        block = {
            avm.getAnimeList()
        }
    )

    Column() {

        Box(){
            Surface() {
                Row {

                }
            }
        }
    }

    Column {
        if (avm.errorMessage.isEmpty()) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(120.dp)
            ) {
                items(avm.animeList.size) { index ->
//                    Text(text = avm.animeList[index].title)
//                    Text(text = avm.animeList[index].imgUrl)
//                    Text(text = avm.animeList[index].Deskripsi)



                    Box(
                        modifier = Modifier
                            .padding(8.dp, 4.dp)
                            .fillMaxWidth()
                            .height(110.dp)
                    ) {
                        Surface() {

                            Row(
                                Modifier
                                    .padding(4.dp)
                                    .fillMaxSize()
                            ) {

                                Image(
                                    painter = rememberImagePainter(
                                        data = avm.animeList[index].imgUrl,

                                        builder = {
                                            scale(Scale.FILL)
                                            placeholder(R.drawable.notification_action_background)
                                            transformations(CircleCropTransformation())

                                        }
                                    ),
                                    contentDescription = avm.animeList[index].Deskripsi,
                                    modifier = Modifier
                                        .fillMaxHeight()
                                        .weight(0.2f)
                                )


                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    modifier = Modifier
                                        .padding(4.dp)
                                        .fillMaxHeight()
                                        .weight(0.8f)
                                ) {
                                    Text(
                                        text = avm.animeList[index].title,
                                        style = MaterialTheme.typography.subtitle1,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = avm.animeList[index].genre,
                                        style = MaterialTheme.typography.caption,
                                        modifier = Modifier
                                            .background(
                                                Color.LightGray
                                            )
                                            .padding(4.dp)
                                    )
                                    Text(
                                        text = avm.animeList[index].Deskripsi,
                                        style = MaterialTheme.typography.body1,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )

                                }
                            }
                        }
                    }









                }
            }
        }
        else {
            Text(text = avm.errorMessage)
        }
    }
}