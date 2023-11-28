package com.yeditepe.weekthreesectionone.weeknine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme
import java.security.AllPermission

sealed class Screen(val route:String){
    object Profile: Screen("profile")
    object FriendList: Screen("friendlist")
}

var list=listOf(
    Screen.Profile,
    Screen.FriendList
)
@Composable
fun Profile(controller: NavController,
modifier: Modifier){
    
    Column(modifier=modifier ,
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "Profile")
               
    }
}
@Composable
fun FriendList(controller: NavController,
            modifier: Modifier){

    Column(modifier=modifier ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "FriendList")

    }
}

@ExperimentalMaterial3Api
@Composable
fun MainScreenWithBottomBar(){
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                list.forEach { screen ->
                    BottomNavigationItem(
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                        onClick = {
                            navController.navigate(screen.route)
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(navController, startDestination = Screen.Profile.route, Modifier.padding(innerPadding)) {
            composable(Screen.Profile.route) { Profile(navController, modifier = Modifier.fillMaxWidth()) }
            composable(Screen.FriendList.route) { FriendList(navController, modifier = Modifier.fillMaxWidth()) }
        }
    }

}
@ExperimentalMaterial3Api
@Preview
@Composable
fun PreviewMain(){
    WeekThreeSectionOneTheme {
        MainScreenWithBottomBar()
    }
}