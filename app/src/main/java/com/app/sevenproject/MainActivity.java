package com.app.sevenproject;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView posts;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        swipeRefreshLayout = findViewById(R.id.swipe);

        posts = findViewById(R.id.ls);
        postAdapter = new PostAdapter();
        posts.setAdapter(postAdapter);
        posts.setLayoutManager(new LinearLayoutManager(this));


        load();

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                load();
            }
        });

    }

    void load() {
        Api.getClient().GetPosts().enqueue(new Callback<List<PostModel>>() {
            @Override
            public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
                postAdapter.setPostModels((ArrayList<PostModel>) response.body());
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onFailure(Call<List<PostModel>> call, Throwable t) {

            }
        });

    }
}
