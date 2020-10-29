package com.dicoding.picodiploma.githubuser;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.dicoding.picodiploma.githubuser.adapter.PagerAdapter;

import com.dicoding.picodiploma.githubuser.model.User;
import com.dicoding.picodiploma.githubuser.retrofit.APIClient;
import com.dicoding.picodiploma.githubuser.retrofit.RetrofitConfiguration;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class DetailAcitivity extends AppCompatActivity {
    private CircleImageView imageView;
    private TextView username,followers, following, company, location;
    private ProgressBar progressBar;
    private User userGit;

    private ArrayList<User> user = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.progressBar1);
        setDetailUser();



        PagerAdapter pagerAdapter =new PagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(pagerAdapter);
        TabLayout tabLayout =findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        getSupportActionBar().setElevation(0);


    }
    private void setDetailUser() {
        user =getIntent().getParcelableExtra("DATA_USER");
        if (user != null) {
            username = findViewById(R.id.tv_name);
            followers = findViewById(R.id.tv_followers);
            following = findViewById(R.id.tv_following);
            company = findViewById(R.id.tv_company);
            location = findViewById(R.id.tv_location);
            imageView = findViewById(R.id.avatar_user);
            progressBar.setVisibility(View.VISIBLE);
            APIClient apiClient = RetrofitConfiguration.getRetrofit().create(APIClient.class);
            Call<User> call = apiClient.getUserDetail(userGit.getLogin());
            call.enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (response.body() != null){
                        username.setText(String.valueOf(response.body().getName()));
                        followers.setText(String.valueOf(response.body().getFollowers()));
                        following.setText(String.valueOf(response.body().getFollowing()));
                        company.setText(String.valueOf(response.body().getCompany()));
                        location.setText(String.valueOf(response.body().getLocation()));
                        Glide.with(getApplicationContext()).load(response.body().getAvatarUrl()).into(imageView);
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable throwable) {

                }
            });
        }
    }
}

