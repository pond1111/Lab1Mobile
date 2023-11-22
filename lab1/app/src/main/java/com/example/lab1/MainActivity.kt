package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab1.ui.theme.Lab1Theme

data class Person(val name:String,
                  val studentID:String,
                  val imageID:Int)

class MainActivity : ComponentActivity(){
    var persons: List<Person> = listOf<Person>(

        Person("นายอรัญ ศรีสวัสดิ์","643450095-5",R.drawable.arun),

    )
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            Lab1lyoutTheme{
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background)
                {
                    LazyColumn(){
                        items(persons){
                            data -> PersonListItem(data)
                        }
                    }
                }
            }
        }
    }
}
@Composable
fun PersonListItem(data:Person){
    Row(){

        Image(
            painter = painterResource(data.imageID),
            contentDescription = data.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )

        Column(modifier = Modifier.padding(4.dp),
            verticalArrangement = Arrangement.Center){

            Text(data.name)
            Text(data.studentID)
        }
    }
}

