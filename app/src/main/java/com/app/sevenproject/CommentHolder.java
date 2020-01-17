package com.app.sevenproject;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class CommentHolder extends RecyclerView.ViewHolder {

    TextView UName;
    TextView Comment;

    public CommentHolder(@NonNull View itemView) {
        super(itemView);
        UName = itemView.findViewById(R.id.UName);
        Comment = itemView.findViewById(R.id.CommentDes);
    }
}
