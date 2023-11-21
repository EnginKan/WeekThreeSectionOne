package weekeight

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType


import androidx.navigation.compose.NavHost

import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme


@Composable
fun BookLineItem(bookItem: Book,
                 controller: NavHostController,
                 onClick: ()->Unit){
    Row(modifier = Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.primaryContainer)
        .clickable { onClick }) {
        Text(text = bookItem.title,
        style=MaterialTheme.typography.headlineMedium)
        Text(text = bookItem.author,
        style=MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun BookListScreen(viewModel: BookViewModel= viewModel(),
controller: NavHostController
){
    val uiState by viewModel.booklist.collectAsState()
    LazyColumn(){
        items(uiState){
            book->
            BookLineItem(bookItem = book, controller = controller) {
                val route="bookdetails/${book.id}"
                Log.d("LineItem",route)
                controller.navigate(route)
                
            }
        }
    }
    
}

@Composable
fun BookDetailScreen(viewModel: BookViewModel=viewModel(),
               bookId: Int,
controller: NavHostController){
    val book = viewModel.getBookByID(bookId)
    Column(modifier = Modifier.fillMaxWidth()) {
        
        Text(text =book.title,
        style = MaterialTheme.typography.headlineLarge)
        Text(text ="Author:"+book.author,
            style = MaterialTheme.typography.bodyLarge)
        Text(text ="Type:"+book.type,
            style = MaterialTheme.typography.headlineMedium)
        Button(onClick = {
            controller.navigate("booklist")
        }) {

        }
    }
    
}



@Composable
fun BookMainScreen(controller: NavHostController = rememberNavController()){



    NavHost(navController = controller, startDestination = "booklist") {

        composable("booklist") {
            BookListScreen(controller = controller)

        }
        composable(
            "bookdetails/{id}",
            arguments = listOf(navArgument("id"){type= NavType.IntType}
        ) )
        { stack ->
            val bookid= stack.arguments?.getInt("id")
            println(bookid)
            BookDetailScreen(
                bookId = stack.arguments!!.getInt("id", 0),
                controller = controller
            )
        }

    }


}
@Preview
@Composable
fun BookMainScreenPreview(){
    WeekThreeSectionOneTheme() {
        BookMainScreen()
    }

}