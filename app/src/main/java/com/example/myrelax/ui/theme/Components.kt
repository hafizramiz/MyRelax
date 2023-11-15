package com.example.myrelax.ui.theme

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrelax.R
import com.example.myrelax.data.alignYourBodyData
import com.example.myrelax.data.favoriCollectionsData


// Search bar olusturdum.
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    // Her zaman icin default modifier gecmek best practice'dir.
    // Her composable ogesi modifier turunde bir parametre'yi almadilir.
    modifier: Modifier = Modifier
) {
    TextField(
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Search")
        },
        colors = TextFieldDefaults.textFieldColors(
            unfocusedIndicatorColor = MaterialTheme.colorScheme.surface,
            focusedIndicatorColor = MaterialTheme.colorScheme.surface
        ),
        placeholder = {
            Text(text = stringResource(id = R.string.placerholder_search))
        },
        value = "", onValueChange = {},
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(56.dp),
        )
}


@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @DrawableRes picture: Int
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Resim'e sekil vermek icin clip ve onun da icin88e CircleShape ekliyorz.
        Image(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            painter = painterResource(id = picture),
            contentDescription = "yoga",
            // Resmi sekil icinde duzenlemek icin contentScale kullanilir. Flutter'da fit cover ozelligi burda da var.
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.bodyMedium,
            //
            modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    @DrawableRes picture: Int
) {
    Surface(
        modifier = Modifier
            .width(200.dp)
            .height(100.dp)
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
        ) {

            // Column ve Row'un cross-axis'ni ayarlamak icin ALignment parametresi kullanilir.
            // Bu columnda horizantalAlignment'dir. Cunku COlumn vertical olusur. Bunun cross-axis'ni ayaralamak
            // icin alignment propertisi kullanilir. Hangi aligmnent? horizantalAligment. cross-axis'ne uygun gelen
            // alignment.Row'da ise cross-axis vertical oldugu icin vertical aligmnet kullanilir.
            // Column'da horizantalAlignment var
            // Main axis'lerde nasil yerlesecegini belirlemek icin de arrangment propertisi kullanilir.
            // Column'un main axis'i vertical oldugu icin verticalArrangement =  kullanilir.
            // Row'a ise mainaxis horizantal oldugu icin  horizontalArrangement kullanilir.
            // Yani arrangment main axis icin kullanilan paramtre ismidir

            // Row'da vertical aligment yapmamiz gerekiyor.Vertical olarak ortalamak icin
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(250.dp),
            ) {
                Image(
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(80.dp),
                    painter = painterResource(id = picture),
                    contentDescription = null
                )
                Text(
                    modifier = Modifier.padding(horizontal = 15.dp),
                    text = stringResource(id = text),
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
    }
}


@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(alignYourBodyData.size) {
            AlignYourBodyElement(
                text = alignYourBodyData[it].text,
                picture = alignYourBodyData[it].picture
            )
        }
    }
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Burda grid'e size nasil vercez?

    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier.height(200.dp)
    ) {
        items(favoriCollectionsData.size) {
            FavoriteCollectionCard(
                text = favoriCollectionsData[it].text,
                picture = favoriCollectionsData[it].picture
            )

        }
    }
}

@Composable
fun HomeSection(
    modifier: Modifier = Modifier,
    @StringRes text: Int,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            text = stringResource(id = text),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
        )
        content()
    }
}


@Composable
private fun RelaxBottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(modifier = Modifier) {
        NavigationBarItem(selected = true, onClick = {
        }, icon = {
            Icon(
                Icons.Rounded.ShoppingCart,
                contentDescription = null
            )
        },
            label = {
                Text(text = "Home")
            }
        )
        NavigationBarItem(
            selected = false,
            onClick = {
            }, icon = {
                Icon(
                    Icons.Rounded.Person,
                    contentDescription = null
                )
            }, label = {
                Text(text = "Profile")
            }
        )
    }
}



/*
// Scaffold icinde olanlar.
topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
*/
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyRelaxAppPortrait() {
    Scaffold(
        bottomBar = {
            RelaxBottomNavigation()
        }
    ) { innerPadding ->
       HomeScreen(Modifier.padding(innerPadding))
        println(innerPadding)
    }
}

@Composable
private fun RelaxNavigationRail(modifier: Modifier = Modifier) {
    NavigationRail {
        Column(Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(Icons.Rounded.Home, contentDescription = null)
                },
                label = {
                    Text(text = "Home")
                }
            )
            NavigationRailItem(
                selected = false,
                onClick = { /*TODO*/ },
                icon = {
                    Icon(Icons.Rounded.Person, contentDescription = null)
                },
                label = {
                    Text(text = "Profile")
                }
            )
        }

    }
}

@Composable
fun MyRelaxAppLandscape() {
    Row {
        RelaxNavigationRail()
        HomeScreen()
    }

}


// Preview'da gosterirken


@Preview(showBackground = true)
@Composable
fun FavoriteCollectionCardPreview() {
    MyRelaxTheme {

    }
}














