package com.vladimirk.kvnotesmvvm.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.navigation.NavRoute
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme

@Composable
fun AddScreen(navHostController: NavHostController){
    var title by remember {  mutableStateOf("")}
    var subtitle by remember {  mutableStateOf("")}


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
                onValueChange = { title=it},
                label = { Text(text = "Note title")}
              )
            OutlinedTextField(value = subtitle,
                onValueChange ={subtitle=it},
                label = { Text(text = "Note subtitle")}
          )

            Button(onClick = { navHostController.navigate(route = NavRoute.Main.route) },
                modifier = Modifier
                .width(200.dp)
                .padding(vertical = 8.dp)) {
                Text(text = "Add Note")

            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun PrevAddScreen(){
    KvNotesMvvmTheme {
        AddScreen(navHostController = rememberNavController())
    }
    }