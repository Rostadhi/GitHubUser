package com.dicoding.picodiploma.githubuser.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dicoding.picodiploma.githubuser.DetailAcitivity;
import com.dicoding.picodiploma.githubuser.R;
import com.dicoding.picodiploma.githubuser.model.User;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.ViewHolder> {
    private Context context;
    private ArrayList<User> user ;

    public AdapterFavorite(Context context) {
        this.context = context;
    }

    public void setUserGithubList(ArrayList<User> userGithubArrayList){
        this.user = userGithubArrayList;
    }
    @NonNull
    @Override
    public AdapterFavorite.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavorite.ViewHolder holder, int position) {
        User userGithub = user.get(position);
        holder.textView.setText(userGithub.getLogin());
        Glide.with(holder.itemView.getContext())
                .load(userGithub.getAvatarUrl())
                .into(holder.circleImageView);


    }

    @Override
    public int getItemCount() {
        return user.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CircleImageView circleImageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView_avatar);
            textView = itemView.findViewById(R.id.tv_user);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User userGithub = user.get(getAdapterPosition());
            Intent intent = new Intent(context, DetailAcitivity.class);
            intent.putExtra("DATA_USER",userGithub);
            view.getContext().startActivity(intent);
        }
    }
}
