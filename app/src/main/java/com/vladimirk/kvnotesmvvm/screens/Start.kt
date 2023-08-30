package com.vladimirk.kvnotesmvvm.screens

import android.app.Application
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.MainViewModel
import com.vladimirk.kvnotesmvvm.MainViewModelFactory
import com.vladimirk.kvnotesmvvm.navigation.NavRoute
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme
import com.vladimirk.kvnotesmvvm.utils.TYPE_FIREBASE
import com.vladimirk.kvnotesmvvm.utils.TYPE_ROOM

@Composable
fun StartScreen(navHostController: NavHostController,viewModel: MainViewModel){

  //  val  context= LocalContext.current
   // val ViewModel:MainViewModel= viewModel(factory = MainViewModelFactory(context.applicationContext as Application))

       Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize(),
             horizontalAlignment = Alignment.CenterHorizontally,
             verticalArrangement = Arrangement.Center
        ) {
             Text(text = "What will me use?")
             Button(onClick = {
                 viewModel.initDataBase(TYPE_ROOM){
                     navHostController.navigate(route = NavRoute.Main.route)
                 }
                }, modifier = Modifier
                 .width(200.dp)
                 .padding(vertical = 8.dp)) {
                  Text(text = "Room database")

             }
            Button(onClick = {
                viewModel.initDataBase(TYPE_FIREBASE){
                    navHostController.navigate(route = NavRoute.Main.route)
                }
               }, modifier = Modifier
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
         val  context= LocalContext.current
         val mViewModel: MainViewModel = viewModel(factory = MainViewModelFactory(context.applicationContext as Application))
          StartScreen(navHostController = rememberNavController(), viewModel = mViewModel)


          
     }

}