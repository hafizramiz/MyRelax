package com.example.myrelax

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myrelax.ui.theme.AlignYourBodyElement
import com.example.myrelax.ui.theme.FavoriteCollectionCard
import com.example.myrelax.ui.theme.MyRelaxTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
          // MyRelaxApp()
            FavoriteCollectionCard()
        }
    }
}

@Composable
fun MyRelaxApp() {

}