package com.vladimirk.kvnotesmvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vladimirk.kvnotesmvvm.navigation.NoteNavHost
import com.vladimirk.kvnotesmvvm.ui.theme.KvNotesMvvmTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KvNotesMvvmTheme {
                Scaffold(topBar = {
                    TopAppBar(title = { Text(text = "AppNote")}, backgroundColor = Color.Cyan,
                        contentColor = Color.White,
                        elevation = 12.dp
                    )
                }, content = {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {

                       NoteNavHost()
                    }
                })

                // A surface container using the 'background' color from the theme
               // Surface(
                   // modifier = Modifier.fillMaxSize(),
                   // color = MaterialTheme.colors.background
               // ) {
                   // Greeting("Android")
                 //   NoteNavHost()
              //  }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
  //  Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    KvNotesMvvmTheme {
        Greeting("Android")
    }
}