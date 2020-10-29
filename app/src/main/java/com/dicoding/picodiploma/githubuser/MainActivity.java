package com.dicoding.picodiploma.githubuser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.dicoding.picodiploma.githubuser.adapter.UserAdapter;
import com.dicoding.picodiploma.githubuser.model.SearchUser;
import com.dicoding.picodiploma.githubuser.model.User;
import com.dicoding.picodiploma.githubuser.retrofit.APIClient;
import com.dicoding.picodiploma.githubuser.retrofit.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private List<User> github = new ArrayList<>();
    private String e7dc9c81148e9c67caf65ccff685074e53a6d605;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView =findViewById(R.id.rv_user);
        recyclerView.setHasFixedSize(true);
        showRecyclerList();


        APIClient apiClient = RetrofitConfiguration.getRetrofit().create(APIClient.class);
        Call<List<User>> call = apiClient.getGithubUser(e7dc9c81148e9c67caf65ccff685074e53a6d605);
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                UserAdapter userAdapter = new UserAdapter(response.body());
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable throwable) {

            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        if (searchManager != null) {
            SearchView searchView = (SearchView) (menu.findItem(R.id.search)).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setQueryHint(getResources().getString(R.string.search));
            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String username) {
                    Toast.makeText(MainActivity.this, username, Toast.LENGTH_SHORT).show();
                    getDataUser(username);
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }
        return super.onCreateOptionsMenu(menu);
    }

    private void getDataUser(String username) {
        progressBar.setVisibility(View.VISIBLE);
        APIClient api = RetrofitConfiguration.getRetrofit().create(APIClient.class);
        Call<SearchUser> call = api.getGithubSearch(username);

        call.enqueue(new Callback<SearchUser>() {
            @Override
            public void onResponse(Call<SearchUser> call, Response<SearchUser> response) {
                progressBar.setVisibility(View.INVISIBLE);
                UserAdapter adapter = new UserAdapter(response.body().getItems());
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<SearchUser> call, Throwable throwable) {
                progressBar.setVisibility(View.INVISIBLE);

            }
        });
    }
    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        UserAdapter userAdapter = new UserAdapter(github);
        recyclerView.setAdapter(userAdapter);
    }

}