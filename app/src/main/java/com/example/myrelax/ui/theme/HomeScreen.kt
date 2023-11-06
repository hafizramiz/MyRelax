package com.example.myrelax.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.myrelax.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
// Butun composable'lara varsayilan olarak modifier verilmesinin sebebi,
// Onu baska bir yerde cagirdigimizda rahatlikla customize edebilmemize yariyor.
// Ornegin burda simdi SearchBar composable'ni cagirip kullancam. Onun varsayilan bir modifier degeri var. Ben ona
// parametre gecerek rahatlikla customize edebilirim. Ama su an kullanmadim.
    // Column'a burda scrollable ozelligi de katmam gerekiyor.

    Column(modifier.verticalScroll(rememberScrollState())) {
        Spacer(modifier = Modifier.height(10.dp))
        SearchBar()
        HomeSection(text = R.string.my_relaxing_activity) {
            AlignYourBodyRow()
        }
        HomeSection(text = R.string.recently_added) {
            FavoriteCollectionsGrid()
        }
    }


}