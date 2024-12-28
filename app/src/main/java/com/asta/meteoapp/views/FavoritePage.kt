package com.asta.meteoapp.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.asta.meteoapp.components.weatherDataFavorite
import com.asta.meteoapp.datacontracts.WeatherData
import com.asta.meteoapp.model.FavoriteModel

@Composable
fun FavoritePage(modifier: Modifier=Modifier, favoriteModel: FavoriteModel= viewModel()){
    var weatherFavoriteList = favoriteModel.getWeatherFavoriteList()
    Column(modifier) {
        Text("Vos favoris")
        LazyColumn {
            items(items=weatherFavoriteList){ item ->
                var value = remember { mutableStateOf(true) }
                weatherDataFavorite(
                    modifier = Modifier.fillMaxWidth(),
                    weatherData = item,
                    isInfavorite = value,
                    onClick = {
                        value.value = !value.value
                    }
                )
            }
        }
    }
}

@Composable
@Preview
fun FavoritePagePreview(){
    FavoritePage()
}