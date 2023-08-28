package com.vladimirk.kvnotesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
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
fun NoteNavHost(){
    val navacontroller= rememberNavController()
    NavHost(navController = navacontroller, startDestination =NavRoute.Start.route){
        composable(NavRoute.Start.route){ StartScreen(navHostController = navacontroller) }
        composable(NavRoute.Main.route){ MainScreen(navHostController = navacontroller) }
        composable(NavRoute.Add.route){ AddScreen(navHostController = navacontroller) }
        composable(NavRoute.Note.route){ NoteScreen(navHostController = navacontroller) }
        }

}


