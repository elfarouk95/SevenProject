package com.app.sevenproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("/posts")
    Call<List<PostModel>> GetPosts();


    @GET("/comments")
    Call<List<CommentModel>> GetComments(@Query("postId") int postId);


}