package com.app.sevenproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CommentActivity extends AppCompatActivity {

    RecyclerView ls;

    CommentAdapter commentAdapter;

    TextView Name;
    TextView PostDes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ls = findViewById(R.id.Comments);

        commentAdapter = new CommentAdapter();
        ls.setAdapter(commentAdapter);
        ls.setLayoutManager(new LinearLayoutManager(this));


        Name = findViewById(R.id.Name);
        PostDes = findViewById(R.id.PostDes);

        Intent n = getIntent();

        long id = n.getLongExtra("id", 0);

        String name = n.getStringExtra("Name");
        String body = n.getStringExtra("Des");

        Name.setText(name);
        PostDes.setText(body);

        Api.getClient().GetComments((int) id).enqueue(new Callback<List<CommentModel>>() {
            @Override
            public void onResponse(Call<List<CommentModel>> call, Response<List<CommentModel>> response) {
                commentAdapter.setCommentModels((ArrayList<CommentModel>) response.body());
            }

            @Override
            public void onFailure(Call<List<CommentModel>> call, Throwable t) {

            }
        });

    }
}
