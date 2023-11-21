package weekeight

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

object Routes{
    val route1="Screen1"
    val route2= "Screen2"
}

@Composable
fun ScreenOne(onClick : ()->Unit){

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colorScheme.secondaryContainer)) {
        Box(modifier=Modifier.background(color=MaterialTheme.colorScheme.primaryContainer)){
          Text(text = "1",
          style = MaterialTheme.typography.bodyLarge)

        }
        Button(onClick = onClick ) {
            Text(text = "Go to Scree Two")

        }

    }
}
@Composable
fun ScreenTwo(onClick: ()->Unit){

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.secondaryContainer)) {
        Box(modifier=Modifier.background(color=MaterialTheme.colorScheme.primaryContainer)){
            Text(text = "2",
                style = MaterialTheme.typography.bodyLarge)

        }
        Button(onClick = onClick) {
            Text(text = "Go to Scree One")

        }

    }
}

@Composable
fun MainScreen(controller: NavHostController = rememberNavController()){

    NavHost(navController =controller , startDestination = Routes.route1 ){
        composable(Routes.route1){ScreenOne(
            onClick={controller.navigate(Routes.route2)})}
        composable(Routes.route2){ScreenTwo(
            onClick={controller.navigate(Routes.route1)}
        )}
    }
}

@Preview
@Composable
fun MainScreenPreview(){
    WeekThreeSectionOneTheme {
        MainScreen()

    }
}