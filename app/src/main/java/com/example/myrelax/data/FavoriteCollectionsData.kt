package com.example.myrelax.data
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.myrelax.R


// Burda maplerden olusan bir liste olusturdum. Simdi buna map metotu uygulayip hepsini model sinifina donusturcem
val favoriCollectionsData = listOf(
    R.drawable.yoga to R.string.yoga,
    R.drawable.fitness to R.string.fitness,
    R.drawable.stretching to R.string.stretching,
    R.drawable.swimming to R.string.swimming,
    R.drawable.crossfit to R.string.crossfit,
    R.drawable.meditation to R.string.meditation,
    R.drawable.music to R.string.music
).map {
    println("it: $it")
    FavoriteCollectionsData(it.first,it.second)
}


val alignYourBodyData= listOf(
    R.drawable.yoga to R.string.yoga,
    R.drawable.fitness to R.string.fitness,
    R.drawable.stretching to R.string.stretching,
    R.drawable.swimming to R.string.swimming,
    R.drawable.swimming to R.string.swimming,
    R.drawable.swimming to R.string.swimming,
).map {
    println("it: $it")
    FavoriteCollectionsData(it.first,it.second)
}



// Burada bir data class olusturdum. Bundan olusturulmus nesneler ile listenin icini doldurcam.
data class FavoriteCollectionsData(
    @DrawableRes
    val picture:Int,
    @StringRes
    val text: Int
)


