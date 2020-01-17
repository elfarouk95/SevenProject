package com.app.sevenproject;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class PostAdapter extends RecyclerView.Adapter<PostHolder> {


    ArrayList<PostModel> postModels = new ArrayList<>();

    public void setPostModels(ArrayList<PostModel> postModels) {
        this.postModels = postModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.postitem, viewGroup, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder p, final int i) {

        p.Name.setText(postModels.get(i).getTitle());
        p.PostDes.setText(postModels.get(i).getBody());

        p.Comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent n = new Intent(v.getContext(), CommentActivity.class);
                n.putExtra("id", postModels.get(i).getId());
                n.putExtra("Name", postModels.get(i).getTitle());
                n.putExtra("Des", postModels.get(i).getBody());
                v.getContext().startActivity(n);
            }
        });

    }

    @Override
    public int getItemCount() {
        return postModels.size();
    }
}
