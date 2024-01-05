package com.javicia.helloworldcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar() },
        content = { Content() },
        floatingActionButton = { FAB()},
        floatingActionButtonPosition = FabPosition.End
    )
}

@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = {
        Toast.makeText(context, "Has pulsado el toast", Toast.LENGTH_SHORT).show()
    }){
        Text(text = "X")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Javicia Profile", color = colorResource(id = R.color.white)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.background))

    )
}


@Composable
fun Content() {
    var counter by rememberSaveable { mutableStateOf(0) }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Red)
    ) {
        item {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                painter = painterResource(id = R.drawable.cabecera),
                contentDescription = "cabecera"
            )
            Row(modifier = Modifier.padding(top = 8.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.ic_fav),
                    contentDescription = "like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    color = Color.White,
                    modifier = Modifier.padding(start = 4.dp)
                )
            }
            Text(
                text = "Javicia",
                fontSize = 32.sp,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
            Text(text = "Cia", color = Color.White)
            Text(text = "Hola", color = Color.White)
            LazyRow(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            {
                item {
                    Text(text = "Java", color = Color.White)
                    Text(text = "Kotlin", color = Color.White)
                    Text(text = "JavaScript", color = Color.White)
                    Text(text = "HTML", color = Color.White)
                    Text(text = "CSS", color = Color.White)
                    Text(text = "Python", color = Color.White)
                    Text(text = "MySql", color = Color.White)
                    Text(text = "Flutter", color = Color.White)
                    Text(text = "XML", color = Color.White)
                    Text(text = "Angular", color = Color.White)
                    Text(text = "Boostrap", color = Color.White)
                }
            }
        }
    }
}