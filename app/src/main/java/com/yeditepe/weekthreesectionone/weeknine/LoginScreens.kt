package com.yeditepe.weekthreesectionone.weeknine

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation

@ExperimentalMaterial3Api
@Composable
fun EmailScreen(){
    Column(modifier = Modifier.fillMaxWidth(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value ="" , onValueChange = {})
     Button(onClick = { /*TODO*/ }) {
         Text(text= "Next")
         Icon(Icons.Filled.ArrowForward, contentDescription ="" )

     }
    }
}

@ExperimentalMaterial3Api
@Composable
fun PasswordScreen(){
    Column(modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value ="" , onValueChange = {})
        Button(onClick = { /*TODO*/ }) {
            Text(text= "Next")
            Icon(Icons.Filled.ArrowForward, contentDescription ="" )

        }
    }
}
@ExperimentalMaterial3Api
@Composable
fun NavGraphBuilder.loginGraph(navController: NavController){
    navigation(startDestination = "email", route = "login"){
        composable("email"){ EmailScreen()}
        composable("password"){ PasswordScreen()}
    }
}
@Composable
@ExperimentalMaterial3Api
fun MainPage(){
    val navController= rememberNavController();
    Column(modifier = Modifier.fillMaxWidth()) {
       NavHost(navController =navController , startDestination = "login" , route = "login"){
           //loginGraph(navController = navController)

       }

    }
}