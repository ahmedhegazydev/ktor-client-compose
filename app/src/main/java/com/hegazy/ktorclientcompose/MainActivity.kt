package com.hegazy.ktorclientcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.hegazy.ktorclientcompose.data.remote.PostsService
import com.hegazy.ktorclientcompose.data.remote.dto.PostResponse
import com.hegazy.ktorclientcompose.ui.theme.KtorClientComposeTheme

class MainActivity : ComponentActivity() {


    private val postsService = PostsService.create()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = postsService.getPosts()
                })

            KtorClientComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
//                    Greeting("Android")
                    LazyColumn {
                        items(posts.value) {
                            println("testing val " + it.title)
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(5.dp)
                            ) {
                                Text(text = it.title, fontSize = 20.sp,)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = it.body, fontSize = 16.sp, )
                            }
                        }
                    }
                }
            }
        }
    }
}

