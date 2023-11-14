package com.yeditepe.weekthreesectionone.composableexamples

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yeditepe.weekthreesectionone.R
import com.yeditepe.weekthreesectionone.ui.theme.WeekThreeSectionOneTheme

data class Post(val sender: String,
                var like: Int= 0,
                var unlike: Int= 0,
                    var image: Int)

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@ExperimentalMaterial3Api
@Composable
fun MainScreen(posts:List<Post>){
    Scaffold(
        topBar =  {
            TopAppBar(
                title = {
                    Text("Top app bar")
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary,
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                )
            }
        }
    ){paddingValues->
        LazyColumn{
            items(posts){
                post-> SinglePost(post = post)
            }

        }

    }
    }


@ExperimentalMaterial3Api
@Composable
fun SinglePost(post: Post){

    Card(
        onClick = { /*TODO*/ }
        ,modifier = Modifier.fillMaxWidth().padding(horizontal=10.dp),
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically){
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(20.dp)
                    .clip(CircleShape),
                contentDescription =""
            )
            Text(text =post.sender,
            style = MaterialTheme.typography.titleMedium)
        }
        Image(painter = painterResource(id = post.image) ,
            contentDescription ="",
            modifier= Modifier
                .size(150.dp).
                border(BorderStroke(1.dp, Color.Black)),
            alignment = Alignment.Center
                )
        Spacer(modifier = Modifier.padding(5.dp))
       Row {
           Button(onClick = { post.like++
           Log.d("Like:",post.like.toString())}) {
               Icon(
                   painter = painterResource(
                       id = if (post.like > 0) R.drawable.baseline_done_24
                       else R.drawable.baseline_done_all_24
                   ),
                   contentDescription = ""
               )
               Text(text = if (post.like > 0) "Like:" + post.like else "Like")
           }
           Button(onClick = { post.unlike++
               Log.d("Unlike:",post.unlike.toString())}) {
               Icon(
                   painter = painterResource(
                       id = if (post.unlike > 0) R.drawable.outline_cancel_24
                       else R.drawable.baseline_cancel_24
                   ),
                   contentDescription = ""
               )
               Text(text = if (post.unlike > 0) "Unlike:" + post.unlike else "Unlike")
           }
       }

    }
}

@Preview(showSystemUi = true)
@ExperimentalMaterial3Api
@Composable
fun SinglePostPreview(){
    WeekThreeSectionOneTheme(darkTheme = true) {
        var post= Post(sender="Engin", like = 0,
        unlike = 0,image=R.drawable.ic_launcher_background)
        var posts= mutableListOf<Post>()
        for(i in 1..100)
            posts.add(post)
        MainScreen(posts = posts)
    }
}