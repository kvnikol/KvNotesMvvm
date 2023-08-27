package com.vladimirk.kvnotesmvvm.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vladimirk.kvnotesmvvm.screens.Add
import com.vladimirk.kvnotesmvvm.screens.Main
import com.vladimirk.kvnotesmvvm.screens.Note
import com.vladimirk.kvnotesmvvm.screens.Start

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
        composable(NavRoute.Start.route){ Start(navHostController = navacontroller) }
        composable(NavRoute.Main.route){ Main(navHostController = navacontroller) }
        composable(NavRoute.Add.route){ Add(navHostController = navacontroller) }
        composable(NavRoute.Note.route){ Note(navHostController = navacontroller) }
        }

}


