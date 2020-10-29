package com.dicoding.picodiploma.githubuser.retrofit;

import com.dicoding.picodiploma.githubuser.model.SearchUser;
import com.dicoding.picodiploma.githubuser.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIClient {
    @GET("/users")
    Call<List<User>> getGithubUser(@Header("Authentication") String token);

    @GET("/search/users")
    Call<SearchUser> getGithubSearch(
            @Query("q") String username
    );
    @GET("users/{username}")
    Call<User> getUserDetail(@Path("username") String username);

    @GET("/users/{username}/followers")
    Call<List<User>> getFollower(@Path("username") String username);

    @GET("/users/{username}/following")
    Call<List<User>> getFollowing(@Path("username") String username);
}
