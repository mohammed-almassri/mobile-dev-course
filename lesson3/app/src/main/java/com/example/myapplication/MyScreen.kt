package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

fun onImageClick(current:Int):Int{
    return (current+1)%3
}

@Composable
fun MyScreen(modifier: Modifier = Modifier) {
    val images = listOf<Int>(R.drawable.boat,R.drawable.car,R.drawable.plane)
    var current by remember() { mutableIntStateOf(0) };
    Scaffold { innerPadding ->
        Column {
            Text(text=current.toString())
            Row(modifier= Modifier.padding(innerPadding)) {
//                Box(modifier= Modifier.size(100.dp)){
                    Image(painter = painterResource(images[current]), contentDescription = null,modifier= Modifier.size(50.dp).clickable(onClick = {current=onImageClick(current)}))
                    Image(painter = painterResource(images[(current+1)%3]), contentDescription = null,modifier= Modifier.size(50.dp).clickable(onClick = {current=onImageClick(current)}))
                    Image(painter = painterResource(images[(current+2)%3]), contentDescription = null,modifier= Modifier.size(50.dp).clickable(onClick = {current=onImageClick(current)}))
//                }
            }
           Row (modifier= Modifier.fillMaxWidth().padding(innerPadding), horizontalArrangement = Arrangement.Center){ Box(){
               Image(
                   painter = painterResource(R.drawable.ic_launcher_background),
                   contentDescription = null,
                   modifier= Modifier.clip(CircleShape)
               )
               Image(
                   painter = painterResource(R.drawable.ic_launcher_foreground),
                   contentDescription = null,
               )

           } }
            for (i in 0..1){
                CustomRow((i*20).dp)
            }
        }
    }
}

@Composable
private fun CustomRow(horizontalPadding: Dp) {
    Row(
        modifier = Modifier
            .padding(horizontal =horizontalPadding, vertical = 50.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        TextComponent("MIU")
        TextComponent("MIU")
        TextComponent("MIU")
        TextComponent("MIU")
    }
}

@Composable
fun TextComponent(text:String){
    Text(
        color = Color.Red,
        text = text,
        modifier = Modifier.background(Color.Black).padding(
            4.dp
        ),
        fontSize = 30.sp
    )
}

@Preview(showSystemUi = true)
@Composable
fun MyScreenPreview(){
    MyScreen()
}