package com.example.myrelax.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrelax.R
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

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
    modifier: Modifier = Modifier
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // Resim'e sekil vermek icin clip ve onun da icin88e CircleShape ekliyorz.
        Image(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.yoga),
            contentDescription = "yoga",
            // Resmi sekil icinde duzenlemek icin contentScale kullanilir. Flutter'da fit cover ozelligi burda da var.
            contentScale = ContentScale.Crop,
        )
        Text(
            text = stringResource(id = R.string.yoga),
            style = MaterialTheme.typography.bodyMedium,
            //
            modifier = Modifier.padding(top = 10.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant),
        modifier = Modifier.heightIn(min = 80.dp)
    ) {
        // Row'da vertical aligment yapmamiz gerekiyor.Vertical olarak ortalamak icin
        Row(verticalAlignment = Alignment.Bottom) {
            Image(

                contentScale=ContentScale.Crop,
                modifier = Modifier.size(80.dp),
                painter = painterResource(id = R.drawable.swimming),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(10.dp),
                text = stringResource(id = R.string.swimming),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}

@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
}

@Composable
fun FavoriteCollectionsGrid(
    modifier: Modifier = Modifier
) {
    // Implement composable here
}

@Composable
fun HomeSection(
    modifier: Modifier = Modifier
) {
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

}

@Composable
private fun RelaxBottomNavigation(modifier: Modifier = Modifier) {

}

@Composable
fun MyRelaxAppPortrait() {

}

@Composable
private fun RelaxNavigationRail(modifier: Modifier = Modifier) {

}

@Composable
fun MyRelaxAppLandscape() {

}


// Preview'da gosterirken


@Preview(showBackground = true)
@Composable
fun FavoriteCollectionCardPreview() {
    MyRelaxTheme {
        FavoriteCollectionCard(Modifier.padding(8.dp))
    }
}














