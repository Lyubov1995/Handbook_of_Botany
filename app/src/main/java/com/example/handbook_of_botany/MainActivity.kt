package com.example.handbook_of_botany

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.handbook_of_botany.components.InfoScreen
import com.example.handbook_of_botany.ui.theme.Handbook_of_BotanyTheme
import com.example.handbook_of_botany.utils.ListItem
import com.example.handbook_of_botany.utils.Routes

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType",
        "UnusedMaterialScaffoldPaddingParameter"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var item: ListItem? = null

            Handbook_of_BotanyTheme {
                NavHost(
                    navController = navController,
                    startDestination = Routes.MAIN_SCREEN
                ) {
                    composable(Routes.MAIN_SCREEN) {
                        MainScreen(context = this@MainActivity) { listItem ->
                            item = listItem
                            navController.navigate(Routes.INFO_SCREEN)
                        }
                    }

                    composable(Routes.INFO_SCREEN) {
                        InfoScreen(item = item!!)
                    }
                }
            }
        }
    }
}

