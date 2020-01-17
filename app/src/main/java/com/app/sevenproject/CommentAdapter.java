package com.app.sevenproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentHolder> {

    ArrayList<CommentModel> commentModels = new ArrayList<>();

    public void setCommentModels(ArrayList<CommentModel> commentModels) {
        this.commentModels = commentModels;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CommentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.commentitem, viewGroup, false);
        return new CommentHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentHolder c, int i) {

        c.UName.setText(commentModels.get(i).getName());
        c.Comment.setText(commentModels.get(i).getBody());
    }

    @Override
    public int getItemCount() {
        return commentModels.size();
    }
}
