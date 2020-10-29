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

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFragment extends RecyclerView.Adapter<AdapterFragment.ListViewHolder> {
    private Context context;
    private List<User> userList;

    public AdapterFragment(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @NonNull
    @Override
    public AdapterFragment.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFragment.ListViewHolder holder, int position) {
        User user =userList.get(position);
        holder.textView.setText(user.getLogin());
        Glide.with(holder.itemView.getContext()).load(user.getAvatarUrl()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CircleImageView circleImageView;
        TextView textView;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView_avatar);
            textView = itemView.findViewById(R.id.tv_user);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            User user =userList.get(getAdapterPosition());
            Intent intent =new Intent(context, DetailAcitivity.class);
            intent.putExtra("DATA_USER",user);
            view.getContext().startActivity(intent);
        }
    }
}
