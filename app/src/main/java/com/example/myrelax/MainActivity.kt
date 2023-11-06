package com.example.myrelax

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myrelax.ui.theme.AlignYourBodyElement
import com.example.myrelax.ui.theme.AlignYourBodyRow
import com.example.myrelax.ui.theme.FavoriteCollectionCard
import com.example.myrelax.ui.theme.FavoriteCollectionsGrid
import com.example.myrelax.ui.theme.HomeScreen
import com.example.myrelax.ui.theme.MyRelaxAppLandscape
import com.example.myrelax.ui.theme.MyRelaxAppPortrait
import com.example.myrelax.ui.theme.MyRelaxTheme
import com.example.myrelax.ui.theme.SearchBar

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Ekran olculerini aldim.
            val windowSize= calculateWindowSizeClass(this)
           MyRelaxApp(windowSize)
        }
    }
}


@Composable
fun MyRelaxApp(windowSize:WindowSizeClass) {
// Artik burda ekranin buyuklugune gore landscape mi portrait mi gostercem ona karar vercem

    when (windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact-> MyRelaxAppPortrait()
        WindowWidthSizeClass.Expanded-> MyRelaxAppLandscape()
    }
}