package com.vladimirk.kvnotesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.MainViewModel
import com.vladimirk.kvnotesmvvm.screens.AddScreen
import com.vladimirk.kvnotesmvvm.screens.MainScreen
import com.vladimirk.kvnotesmvvm.screens.NoteScreen
import com.vladimirk.kvnotesmvvm.screens.StartScreen


sealed class NavRoute (val route: String){
    object Start:NavRoute("start_screen")
    object Main:NavRoute("main_screen")
    object Add:NavRoute("add_screen")
    object Note:NavRoute("note_screen")
}
@Composable
fun NoteNavHost(mainViewModel: MainViewModel){
    val navacontroller= rememberNavController()
    NavHost(navController = navacontroller, startDestination =NavRoute.Start.route){
        composable(NavRoute.Start.route){ StartScreen(navHostController = navacontroller, viewModel =mainViewModel ) }
        composable(NavRoute.Main.route){ MainScreen(navHostController = navacontroller,viewModel =mainViewModel) }
        composable(NavRoute.Add.route){ AddScreen(navHostController = navacontroller,viewModel =mainViewModel) }
        composable(NavRoute.Note.route){ NoteScreen(navHostController = navacontroller,viewModel =mainViewModel) }
        }

}


