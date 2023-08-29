package com.vladimirk.kvnotesmvvm.screens

import android.app.Application
import android.graphics.fonts.Font
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.MainViewModel
import com.vladimirk.kvnotesmvvm.MainViewModelFactory
import com.vladimirk.kvnotesmvvm.models.Note
import com.vladimirk.kvnotesmvvm.navigation.NavRoute
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme


@Composable
fun MainScreen(navHostController: NavHostController){
    val  context= LocalContext.current
    val viewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
    val  notes = viewModel.readText.observeAsState(listOf()).value
   // val items: List<Note>? by viewModel.readText.observeAsState()


    Scaffold(floatingActionButton = { 
        FloatingActionButton(onClick = { navHostController.navigate(route = NavRoute.Add.route) }) {
            Icon(imageVector = Icons.Filled.Add, contentDescription ="Add icons" )
        
    }}) {
     //  Column() {
          //  NoteItem( note= "NoteItem 1", subtitle ="Subtitle for note 1" , navHostController =navHostController)
          //  NoteItem(title = "NoteItem 2", subtitle ="Subtitle for note 2" , navHostController =navHostController)
          //  NoteItem(title = "NoteItem 3", subtitle ="Subtitle for note 3" , navHostController =navHostController)
          //  NoteItem(title = "NoteItem 4", subtitle ="Subtitle for note 4" , navHostController =navHostController)

     //   }
      LazyColumn{
         items(notes) { note ->
             NoteItem(note =note, navHostController =navHostController)
         }
      }

    }

}

@Composable
fun NoteItem(note:Note,navHostController:NavHostController){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 8.dp)
        .clickable {
            navHostController.navigate(NavRoute.Note.route)
        },
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = note.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Text(text = note.subtitle, fontSize = 24.sp, fontWeight = FontWeight.Bold)
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