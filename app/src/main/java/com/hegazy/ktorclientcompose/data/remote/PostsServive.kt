package com.hegazy.ktorclientcompose.data.remote

import com.hegazy.ktorclientcompose.data.remote.dto.PostRequest
import com.hegazy.ktorclientcompose.data.remote.dto.PostResponse
import io.ktor.client.*
import io.ktor.client.engine.android.*

interface PostsService {

    suspend fun getPosts(): List<PostResponse>

    suspend fun createPost(postRequest: PostRequest): PostResponse?


    companion object{

        fun create(): PostsService{
            return PostsServiceImpl(
                client = HttpClient(Android){

                }
            )
        }

    }

}