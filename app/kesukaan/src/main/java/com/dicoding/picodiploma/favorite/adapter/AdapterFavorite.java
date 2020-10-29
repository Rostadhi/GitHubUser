package com.dicoding.picodiploma.favorite.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.dicoding.picodiploma.favorite.DetailActivity;
import com.dicoding.picodiploma.favorite.R;
import com.dicoding.picodiploma.favorite.model.UserGithub;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdapterFavorite extends RecyclerView.Adapter<AdapterFavorite.ViewHolder> {
    private Context context;
    private Cursor cursor;

    public AdapterFavorite(Context context) {
        this.context = context;
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    private UserGithub getItemData(int position){
        if (!cursor.moveToPosition(position)){
            throw new IllegalStateException("INVALID");
        }
        return new UserGithub(cursor);
    }
    @NonNull
    @Override
    public AdapterFavorite.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterFavorite.ViewHolder holder, int position) {
        UserGithub userGithub = getItemData(position);
        holder.textView.setText(userGithub.getLogin());
        Glide.with(holder.itemView.getContext()).load(userGithub.getAvatarUrl()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CircleImageView circleImageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.circleImageView_avatar_favorite);
            textView = itemView.findViewById(R.id.tv_user_favourite);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            UserGithub userGithub = getItemData(getAdapterPosition());
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("DATA_USER", userGithub);
            view.getContext().startActivity(intent);

        }
    }
}
