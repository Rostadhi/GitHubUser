package com.dicoding.picodiploma.githubuser.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.dicoding.picodiploma.githubuser.DetailAcitivity;
import com.dicoding.picodiploma.githubuser.R;
import com.dicoding.picodiploma.githubuser.model.User;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ListHolder> {
    private List<User> github;

    public UserAdapter(List<User> github) {
        this.github = github;
    }

    @NonNull
    @Override
    public UserAdapter.ListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserAdapter.ListHolder holder, int position) {
        User user = github.get(position);
        Glide.with(holder.itemView.getContext()).load(user.getAvatarUrl()).apply(new RequestOptions().override(80,80)).into(holder.circleImageView);
        holder.textView.setText(user.getLogin());

    }

    @Override
    public int getItemCount() {
        return github.size();
    }

    public class ListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CircleImageView circleImageView;
        TextView textView;
        public ListHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView =itemView.findViewById(R.id.circleImageView_avatar);
            textView =itemView.findViewById(R.id.tv_user);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User user =github.get(getAdapterPosition());
            Intent intent = new Intent(view.getContext(), DetailAcitivity.class);
            intent.putExtra("DATA_USER", user);
            view.getContext().startActivity(intent);
        }
    }
}
