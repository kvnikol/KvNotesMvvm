package com.vladimirk.kvnotesmvvm.screens

import android.app.Application
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
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
fun AddScreen(navHostController: NavHostController,viewModel: MainViewModel){
    var title by remember {  mutableStateOf("")}
    var subtitle by remember {  mutableStateOf("")}
    var isButtonEnabled by remember { mutableStateOf(false) }




    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(text = "Add new notes",
               fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 16.dp))

            OutlinedTextField(value = title,
                onValueChange = {
                    isButtonEnabled=title.isNotEmpty() && subtitle.isNotEmpty()
                    title=it},
                label = { Text(text = "Note title")},
                isError = title.isEmpty()
              )
            OutlinedTextField(value = subtitle,
                onValueChange ={
                    isButtonEnabled=title.isNotEmpty() && subtitle.isNotEmpty()
                    subtitle=it},
                label = { Text(text = "Note subtitle")},
                isError = title.isEmpty()
          )

            Button(enabled = isButtonEnabled,
                onClick = {

                viewModel.addNote(note = Note(title = title, subtitle = subtitle)){
                    navHostController.navigate(route = NavRoute.Main.route)
                }
                 },

                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp))


            {
                Text(text = "Add Note")
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevAddScreen(){
    KvNotesMvvmTheme {
        val  context= LocalContext.current
        val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
        AddScreen(navHostController = rememberNavController(), viewModel = mViewModel)
    }
    }