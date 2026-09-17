package com.example.listycity3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listycity3.ui.theme.ListyCity3Theme

@Composable
fun CityListScreen(
    cities: List<City>,
    onUpdateCity: (City) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier){
        // first text field for the name of the city
        var cityName by remember {mutableStateOf("")}
        var cityProvince by remember {mutableStateOf("")}
        Row(modifier = Modifier.padding(10.dp)) {

            OutlinedTextField(
                value = cityName,
                onValueChange = {newText -> cityName = newText},
                label = {Text("City Name")},
            )
            OutlinedTextField(
                value = cityProvince,
                onValueChange = {newText -> cityProvince = newText},
                label = {Text("City Province")}
            )

        }
        Button(onClick = {onUpdateCity(City(cityName, cityProvince))}) {
            Text("Update City")
        }
        LazyColumn(modifier = modifier) {
            itemsIndexed(cities) { index, city -> // apparently if a lambda function is passed as the last argument
                CityRow(city = city) // then it doesn't need to go into the brackets, so this is still a higher order function
                // except it is outside of the brackets, that seems like a dumb design decision that makes it harder to read code but okay...
                if (index < cities.lastIndex) {
                    HorizontalDivider()
                }
            }
        }
    }

}

@Composable
fun CityRow(city: City) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 16.dp)
    ) {
        Text(
            text = city.name,
            fontSize = 30.sp,
            modifier = Modifier.weight(1f)
        )

        Text(
            text = city.province,
            fontSize = 30.sp,
            modifier = Modifier.weight(1f)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CityListScreenPreview() {
    ListyCity3Theme {
        CityListScreen(
            cities = listOf(
                City("Edmonton", "AB"),
                City("Vancouver", "BC"),
                City("Calgary", "AB")
            ),
            onUpdateCity = {string -> }
        )
    }
}