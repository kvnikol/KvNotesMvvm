package com.vladimirk.kvnotesmvvm.screens

import android.provider.FontsContract.Columns
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.magnifier
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ScaleFactor
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.navigation.NavRoute
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme

@Composable
fun StartScreen(navHostController: NavHostController){
       Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
        ) {
             Text(text = "What will me use?")
             Button(onClick = { navHostController.navigate(route = NavRoute.Main.route) }, modifier = Modifier
                  .width(200.dp)
                  .padding(vertical = 8.dp)) {
                  Text(text = "Room database")

             }
            Button(onClick = { navHostController.navigate(route = NavRoute.Main.route) }, modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)) {
                Text(text = "Firebase database")

            }
             
        }            
       }

  
     
     
}
@Preview(showBackground = true)
@Composable
fun PrevStartScreen(){
     KvNotesMvvmTheme {
          StartScreen(navHostController = rememberNavController())
          
     }

}