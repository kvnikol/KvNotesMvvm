package com.vladimirk.kvnotesmvvm.screens

import android.graphics.fonts.Font
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.navigation.NavRoute
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme

@Composable
fun MainScreen(navHostController: NavHostController){
    Scaffold(floatingActionButton = { 
        FloatingActionButton(onClick = { navHostController.navigate(route = NavRoute.Add.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription ="Add icons" )
        
    }}) {
        Column() {
            NoteItem(title = "NoteItem 1", subtitle ="Subtitle for note 1" , navHostController =navHostController)
            NoteItem(title = "NoteItem 2", subtitle ="Subtitle for note 2" , navHostController =navHostController)
            NoteItem(title = "NoteItem 3", subtitle ="Subtitle for note 3" , navHostController =navHostController)
            NoteItem(title = "NoteItem 4", subtitle ="Subtitle for note 4" , navHostController =navHostController)

        }


    }

}

@Composable
fun NoteItem(title:String,subtitle:String,navHostController:NavHostController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .clickable {
            navHostController.navigate(NavRoute.Note.route)
        },
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = subtitle, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }


    }


}
@Preview(showBackground = true)
@Composable
fun PrevMainScreen() {
    KvNotesMvvmTheme {
        MainScreen(navHostController = rememberNavController())

    }
}